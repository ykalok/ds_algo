package dataStructures.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCollections {
	public static void main(String[] args)
	{
		// Queue using Linked List
		Queue<String> queue = new LinkedList<String>();
		queue.add("A"); // Insert `A` into the queue
		queue.add("B"); // Insert `B` into the queue
		queue.add("C"); // Insert `C` into the queue
		queue.add("D"); // Insert `D` into the queue

		// Prints the front of the queue (`A`)
		System.out.println("The front element is " + queue.peek());

		queue.remove(); // removing the front element (`A`)
		queue.remove(); // removing the front element (`B`)

		// Prints the front of the queue (`C`)
		System.out.println("The front element is " + queue.peek());

		// Returns the total number of elements present in the queue
		System.out.println("The queue size is " + queue.size());

		// check if the queue is empty
		if (queue.isEmpty()) {
			System.out.println("The queue is empty");
		} else {
			System.out.println("The queue is not empty");
		}

		// Doubly Ended Queue using Linked List

		Deque<String> deque = new LinkedList<String>();
		// We can add elements to the queue
		// in various ways
		// Add at the last
		deque.add("Element 1 (Tail)");

		// Add at the first
		deque.addFirst("Element 2 (Head)");

		// Add at the last
		deque.addLast("Element 3 (Tail)");

		// Add at the first
		deque.push("Element 4 (Head)");

		// Add at the last
		deque.offer("Element 5 (Tail)");

		// Add at the first
		deque.offerFirst("Element 6 (Head)");

		System.out.println(deque + "\n");

		// We can remove the first element
		// or the last element.
		deque.removeFirst();
		deque.removeLast();

		System.out.println("Deque after removing " + "first and last: " + deque);

		// Initializing an Array Deque
		Deque<String> dq = new ArrayDeque<String>();

		// add() method to insert
		dq.add("Alok");
		dq.addFirst("Kumar");
		dq.addLast("Yadav");

		System.out.println(dq);
	}
        
        

}
