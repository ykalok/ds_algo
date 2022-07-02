package dataStructures.Stack;

import java.util.EmptyStackException;

public class StackCrudImpUsingLinkedList<T> {
	// A Linked List Node
	public static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	private StackNode<T> top;
	private int nodesCount;
	 
    public StackCrudImpUsingLinkedList() {
        this.top = null;
        this.nodesCount = 0;
    }
	
	public T pop() {
		if(top== null) {
			throw new EmptyStackException();
		}
		T item =top.data;
		top=top.next;
		this.nodesCount -= 1;
		return item;
	}
	
	public void push(T item) {
		StackNode<T> start = new StackNode<T>(item);
		start.next =top;
		top = start;
		this.nodesCount += 1;
	}
	
	public T peek() {
		if(top==null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top==null;
	}
	
	public int size() {
		return nodesCount;
	}
	
	public static void main(String[] args) {
		StackCrudImpUsingLinkedList<Integer> stackCrudImp = new StackCrudImpUsingLinkedList<Integer>();
		stackCrudImp.push(1);
		stackCrudImp.push(2);
		System.out.println ("Size of Stack: "+stackCrudImp.size());
		stackCrudImp.push(3);
		int data =stackCrudImp.peek();
		System.out.println ("Peek Element: "+data);
		stackCrudImp.push(4);
		data =stackCrudImp.pop();
		System.out.println ("Pop Element: "+data);
		stackCrudImp.push(5);
		System.out.println ("Size of Stack: "+stackCrudImp.size());
	}
}
