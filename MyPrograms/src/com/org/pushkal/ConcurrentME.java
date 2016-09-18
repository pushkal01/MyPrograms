package com.org.pushkal;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentME {
  public static void main(String args[])
  {
	  
	
		 ArrayList<String> list = new ArrayList();
		        list.add("1");
		        list.add("2");
		        list.add("3");
		        list.add("4");
		        list.add("5");
		        Iterator<String> it = list.iterator();
		        list.trimToSize();
		        System.out.println(list.size());
		        list.add("6");
		        System.out.println(list.size());

		        // manipulate list while iterating
		        while (it.hasNext()) {
		         System.out.println("value:" + it.next());
		         it.remove();
		        }}
	  
           }