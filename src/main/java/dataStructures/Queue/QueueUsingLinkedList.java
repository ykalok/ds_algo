package dataStructures.Queue;

import java.util.NoSuchElementException;

public class QueueUsingLinkedList<T> {
	
	public static class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data){
			this.data = data;
		}	
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if(last!=null)
			last.next = t;
		last =t;
		if(first==null)
			first =last;
	}
	
	public T remove() {
		if(first==null)
			throw new NoSuchElementException();
		T data = first.data;
		first=first.next;
		if(first==null) {
			last=null;
		}
		return data;
			
	}
	
	public T peek() {
		if(first==null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	
	public static void main(String[] args) {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<Integer>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println("Remove top element: "+queue.remove());
		queue.add(5);
		System.out.println("peek element: "+queue.peek());
		
		//check queue is empty or not
		
		if(queue.isEmpty()) {
			System.out.println("Queue is Empty");
		}
		else {
			System.out.println("Queue is not Empty");
		}
		
	}

}
