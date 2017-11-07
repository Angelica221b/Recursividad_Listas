package app;

import java.util.Iterator;
import java.util.ListIterator;

import doubleLinkedlist.doubleLinkedlist;
import nodo.node;

public class App {
	
	public static void main(String[] args) {
			
		doubleLinkedlist<String> names = new doubleLinkedlist<String>();
		doubleLinkedlist<String> name = new doubleLinkedlist<String>();
		
		doubleLinkedlist<Integer> enteros = new doubleLinkedlist<Integer>();
		doubleLinkedlist<Integer> ent = new doubleLinkedlist<Integer>();
		
		
		
		//Agregar valores a la lista
		//Metodos agregar
		names.addStart("Alejandro");
		names.addStart("Roxx");
		names.addEnd("Angela");
		names.addStart("Ricardo");
		names.addStart("Jalil");
		names.addEnd("Ang");
		names.addStart("Ang");
		names.addStart("Jose");
		
		name.addStart("Alejandro");
		name.addStart("Roxx");
		name.addEnd("Angela");
		name.addStart("Ricardo");
		name.addStart("Jalil");
		name.addEnd("Ang");
		//name.addStart("Jose");
		System.out.println("Lista 1:");
		System.out.println();
		names.pronter();
		System.out.println("------------");
		System.out.println("Lista 2");
		System.out.println();
		name.pronter();
		System.out.println("------------");
		
		System.out.println("¿Las listas son iguales? "+names.SonIguales(name));
		
		System.out.println("¿Existe el elemento Aleandro en la lista? "+names.ExisteElemento("Alejandro"));
		
		System.out.println("Ocurrencia de Ang: "+names.Ocurrencia("Ang"));
		
		enteros.addStart(23);
		enteros.addStart(54);
		enteros.addEnd(12);
		enteros.addStart(221);
		enteros.addEnd(54);
		
		
		System.out.println("Lista numerica");
		System.out.println();
		enteros.pronter();
		
		System.out.println();
		System.out.println("Suma: "+enteros.Suma());
		
		System.out.println("Maximo: "+enteros.Maximo());
		
		ent.addStart(21);
		ent.addStart(5);
		ent.addEnd(2);
		ent.addStart(21);
		ent.addEnd(4);
		System.out.println("Merge: ");
		enteros.Merge(enteros, ent).pronter();
		
		
		
		//names.addAfter("Jalil", "Andrea");
		//names.addBefore("Jose", "Laura");
		
		/*
		//Impirmir lista
				System.out.println("Imprimir hacia adelante:");
				System.out.println();
				names.pronter();
				System.out.println("----------");
				//Imprimir lista por el final
				System.out.println("Imprimir hacia atras:");
				System.out.println();
				names.print();
		
			
		
		
		
		
		
		
		
		names.removeAfter("Angela");
		names.removeBefore("Jalil");
		names.removeLast();
		names.removeFirst();
		System.out.println();
		System.out.println("Tamaño original de la lista");
		names.size();
		
		System.out.println();
		System.out.println("Lista con valores eliminados:");
		//names.pronter();
		
		Iterator<String> iterator =names.iterator();
		
		
		for(Iterator<String> it=iterator; it.hasNext(); ) {
			System.out.println(iterator.next());
		}
		
		System.out.println();
		System.out.println("Remplazar Ricardo por Emmanuel:");
		names.replace("Ricardo", "Emmanuel");
		names.pronter();
		
		
		System.out.println();
		System.out.println("Tamaño de la lista:");
		names.size();
		System.out.println();
		System.out.println("Indice de Roxx: ");
		names.indexOf("Roxx");
		
		names.Clear();
		System.out.println("Tamaño de la lista luego de usar Clear");
		names.pronter();
		names.size();
		
		
		*/
	}

}
