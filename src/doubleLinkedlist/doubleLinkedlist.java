package doubleLinkedlist;

import java.util.Iterator;

import nodo.node;

public class doubleLinkedlist <T> implements Iterable{
	private node<T> start=null, end=null;
	
	public doubleLinkedlist() {
		start = new node<T>();
		start.setIndex(-1);
				
		end = new node<T>();
		end.setIndex(-1);
	}
	
	public doubleLinkedlist(T value){
		this();
		/*node<T> nuevo=new node<T>(value);
		end.setBack(nuevo);
		start.setNext(nuevo);*/
		
		
		end.setBack(new node<T>(value));
		//end.getBack().setIndex(0); //Index del nuevo nodo
		
		start.setNext(end.getBack());
		start.getNext().setIndex(0); //Index del nuevo nodo
	}
	
	public void addStart(T value){ //Agregar al inicio 
		//El nuevo nodo se agrega en el next del start
		node<T> tmp=start.getNext();
		start.setNext(new node<T>(value));
		
		if(tmp==null) {
			
			end.setBack(start.getNext());
			start.getNext().setIndex(0);
		}else {
			start.getNext().setNext(tmp);
			tmp.setBack(start.getNext());
		}
		
	}
	
	
	public node<T>Search(T value){
		return Search(value, start, end);
	}
	
	private node<T> Search(T value, node<T> start, node<T> end){
		if(start.getNext()==null || end.getBack() == null ) {
			
			return null;
			
		}
		
		else if(start.getNext().getValue().equals(value)){
			return start.getNext();
		}else if(end.getBack().getValue().equals(value)) {
			return end.getBack();
		}
		else if((start.getNext().equals(end)) || (start.equals(end))){
			
			return null;
		}
		return Search(value,start.getNext(),end.getBack());
		
	}
	
	public boolean remove(T value){
		node<T> tmp = Search(value);
		
		if(tmp!=null) {
			if(tmp.getNext()!=null) {
				tmp.getNext().setBack(tmp.getBack());
			}else {
				end.setBack(tmp.getBack());
			}
			if(tmp.getBack()!=null) {
				tmp.getBack().setNext(tmp.getNext());
			}else {
				start.setNext(tmp.getNext());
			}
			reindex();
			return true;
		}
		return false;
	}
	
	public void reindex() {
		node<T> tmp=start;
		int cont=-1;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			
			tmp.setIndex(++cont);
		}
	}
	
	
	public void pronter() {
		node<T> tmp=start;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			System.out.println(tmp.getValue());
		}
	}
	
	
	
	
	public void print(){
		node<T> tmp=end;
		
		while(tmp.getBack()!=null) {
			tmp=tmp.getBack();
			System.out.println(tmp.getValue());
		}
	}
	
	///////////////Metodos faltantes/////////////////////////
	//Agregar alfinal
	public void addEnd(T value) {
		node<T> tmp=end.getBack();
		end.setBack(new node<T>(value));
		
		if(tmp==null) {
			
			start.setNext(end.getBack());
			//end.getBack().setIndex(0);
		}else {
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
			
	}
	
	
	//Eliminar despues de un valor
	public boolean removeAfter(T value){
		node<T> finder = Search(value);
		
		if(finder!=null && finder.getNext()!=null){
			return remove(finder.getNext().getValue());
		}

			return false;
		
	}
	
	//Eliminar antes de un valor
	public boolean removeBefore(T value){
		node<T> finder = Search(value);
		
		if(finder!=null && finder.getBack()!=null){
			return remove(finder.getBack().getValue());
		}

			return false;
		
	}
	
	
	
	//Lista vacia
	public boolean isEmpty() {
		return (start.getNext() == null) ? true : false;
	}

	//Obtener ultimo nodo
	public node<T> getLast() {
		node<T> tmp = end.getBack();
		if (!isEmpty()) {
			return tmp;
		} 
		return null;
	}
	
	//Obtener primer nodo
	public node<T> getFirst() {
		node<T> tmp = start.getNext();
		if (!isEmpty()) {
			return tmp;
		} 
		return null;
	}
	
	//remover ultimo nodo
	public boolean removeLast(){
		//Utilizamos el metodo getLast para tomar el ultimo nodo y llamamos al metodo remove para eliminarlo
		if(!isEmpty()){
			return remove(getLast().getValue());
		}
			return false;
	}
	
	//remover primer nodo
	public boolean removeFirst(){
		//Utilizamos el metodo getFirst para tomar el primer nodo y llamamos al metodo remove para eliminarlo
		if(!isEmpty()){
			return remove(getFirst().getValue());
		}
			return false;
	}

	//tamaño de la lista
	public void size(){
		node<T> tmp = start;
		reindex();
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			
		}
		
		System.out.println(tmp.getIndex());
		
	}
	
	//Indice del nodo
	public void indexOf(T value){
		node<T> finder = Search(value);
		reindex();
		if(finder!=null){
			System.out.println(finder.getIndex());
		}
	}
	
	//Agregar despues de un valor
	public Boolean addAfter(T value, T newvalue){
		node<T> finder = Search(value);
		
		if (finder!=null) {
			if(finder.getNext()!=null) {
				
				finder.getNext().setBack(new node<T>(newvalue));
				finder.getNext().getBack().setNext(finder.getNext());
				finder.setNext(finder.getNext().getBack());
				finder.getNext().setBack(finder);
				
			}else{
				addEnd(newvalue);
			}
		}
		return true;
		
	}
	
	//agregar antes de un valor
	public boolean addBefore(T value, T newvalue){
		node<T> finder = Search(value);
		
		if (finder!=null) {
			if(finder.getBack()!=null) {
				
				finder.getBack().setNext(new node<T>(newvalue));
				finder.getBack().getNext().setBack(finder.getBack());
				finder.setBack(finder.getBack().getNext());
				finder.getBack().setNext(finder);
				
			}else{
				addStart(newvalue);
			}
		}
		return true;
		
	}
	
	
	//remplazar
	public boolean replace(T value, T newvalue){
		node<T> finder = Search(value);
		
		if(finder==null){
			return false;
			
		}
			return addAfter(value, newvalue) && remove(value);
		
		
	}
	
	//vaciar lista
	public boolean Clear(){
		
		while(!isEmpty())
			removeFirst();
		
		return true;
	}
	
	


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			node<T> tmp = start;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				tmp = tmp.getNext();
				return (tmp != null)?true:false;
			}
			@Override
			public T next() {
				// TODO Auto-generated method stub
				return tmp.getValue();
			}
		};
	}
	
	///////////////////////////
	
/////////Tarea Recursividad y listas////////////////
	
	//Ejercicio 1
	public boolean SonIguales(doubleLinkedlist<T> l1 ){
		return SonIguales(start.getNext(),l1.start.getNext());
	}
	
	private boolean SonIguales(node<T> n1, node<T> n2){
		if(n1!=null && n2!=null){
			if (n1.getValue().equals(n2.getValue())) {
				return SonIguales(n1.getNext(),n2.getNext());
				
			}
			else{
				return false;
			}
		}else
			return true;
	}	
	
	
	
	//Ejercicio 2
	public boolean ExisteElemento(T value){
		return ExisteElemento(start.getNext(),value);
	}
	
	private boolean ExisteElemento(node<T> nodo,T value){
		if(nodo!=null){
			if(value.equals(nodo.getValue())){
				return true;
			}else{
				return ExisteElemento(nodo.getNext(),value);
			}
				
		}else
		
		return false;
		
	}
	
	//Ejercicio 3
	public int Ocurrencia(T value){
		return Ocurrencia(start.getNext(),value);
	}
	
	private int Ocurrencia(node<T> nodo,T value){
		if(nodo!=null)
		{
			if(value.equals(nodo.getValue())){
				return Ocurrencia(nodo.getNext(),value)+1;
				
			}else{
				return Ocurrencia(nodo.getNext(),value);
			}
			
		}else
		return 0;
		
	}
	
	//Ejercicio 4
	public int Suma(){
		return Suma(start.getNext());
	}
	
	private int Suma(node<T> nodo){
		if(nodo!=null){
			if(nodo.getValue() instanceof Integer){
				
			return Suma(nodo.getNext())+ (Integer)nodo.getValue();
			
			}
		}
		
		return 0;
	}
	
	//Ejercicio 5
	public doubleLinkedlist<T> Merge(doubleLinkedlist<T> l1, doubleLinkedlist<T>l2){
		node<T> l3= new  node<T>();
		node<T> uno= l1.sort().start;
		node<T> dos= l2.sort().start;
		return Merge(uno.getNext(),dos.getNext(),l3);
	}
	private doubleLinkedlist<T> Merge(node<T> l1, node<T>l2,node<T>l3)
	{
		if(l2!=null)
		{
			
			if(l1!=null){
				node<T> nuevo= new  node<T>();
				nuevo.setValue(l1.getValue());
				nuevo.setNext(l3.getNext());
				l3.setNext(nuevo);
				return Merge(l1.getNext(),l2,l3);
					
			}else{
			
				node<T> _new= new  node<T>();
				_new.setValue(l2.getValue());
				_new.setNext(l3.getNext());
				l3.setNext(_new);
				return Merge(l1,l2.getNext(),l3);	
			} 	
		}else{
		doubleLinkedlist<T> l4 =new doubleLinkedlist<T>();
		l4.start=l3;
		
		return l4.sort();
		}
	}
	
	
	public doubleLinkedlist<T> sort()
	{
		doubleLinkedlist<T> _sort = new doubleLinkedlist<T>();
		node<T> tmp=start,act,last,prev;
		node<T> _new= new node<T>();
		while(tmp.getNext()!=null){
			if (_new.getNext()== null){
				node<T> nuev = new node<T>();
				nuev.setValue(tmp.getNext().getValue());
				_new.setNext(nuev);
			
			}else {
				prev = _new;
				while (prev.getNext()!= null){
					
					if (((Comparable) prev.getNext().getValue()).compareTo(tmp.getNext().getValue())==1){
						node<T> nuevo = new node<>();
						nuevo.setValue(tmp.getNext().getValue());
						node<T> swp = prev.getNext();
						prev.setNext(nuevo);
						prev.getNext().setNext(swp);
						break;
					}
					
					act = prev;
					prev = prev.getNext();
					
				}//end while _new
				if (prev.getNext()== null){
					node<T> nuevo = new node<>();
					nuevo.setValue(tmp.getNext().getValue());
					prev.setNext(nuevo);
				}
			}
			
			tmp = tmp.getNext();
					
		}
		_sort.start = _new;
		return _sort;
	}
		

	
	//Ejercico 6
		public T Maximo(){
			return Maximo(start.getNext().getNext(),start.getNext().getValue());
		}
		
		private T Maximo(node<T> nodo,T mayor){
			if(nodo!=null){
				if(((Comparable) nodo.getValue()).compareTo(mayor)==1){
					return Maximo(nodo.getNext(),nodo.getValue());
				}else{
					return Maximo(nodo.getNext(),mayor);
				}
			}
			return mayor;
			
		}
	
	
}
