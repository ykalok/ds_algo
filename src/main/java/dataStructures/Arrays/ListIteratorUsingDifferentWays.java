package dataStructures.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorUsingDifferentWays {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Facebook");
		list.add("Amazon");
		list.add("Apple");
		list.add("Netflix");
		list.add("Google");
		
		//Other Ways of add values in List
		//List<String> list = Arrays.asList("Facebook","Amazon","Apple","Netflix","Google");
		
		//Simple For Loop
		System.out.println("===================> 1. For Loop.....");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		//new Inhanced For Loop
		System.out.println("\n===================> 2. Inhanced For Loop.....");
		for(String temp:list) {
			System.out.println(temp);
		}
		
		
		//Iterator
		System.out.println("\n===================> 3. Iterator......");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//List Iterator
		System.out.println("\n===================> 4. List Iterator.....");
		ListIterator<String> litr = list.listIterator();
		while(litr.hasNext()) {
			System.out.println(litr.next());
		}
		
		//While loop
		System.out.println("\n===================> 5. While loop......");
		int i=0;
		while(i<list.size()) {
			System.out.println(list.get(i));
			i++;
		}
		

		//Iterable.forEach() util: return a sequential Stream with this collection as its source
		System.out.println("\n===================> 6. Iterable.forEach().....");
		list.forEach((temp)->{
			System.out.println(temp);
		});
		
		//collection stream.forEach() util: return a sequential Stream with this collection as its source
		System.out.println("\n===================> 7. stream.forEach()......");
		list.stream().forEach((data)->System.out.println(data));	
	}

}
