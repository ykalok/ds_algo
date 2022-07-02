package dataStructures.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	    //private Deque<Integer> deque;
	    private Queue<Integer> queue; 
	    public StackUsingQueue() {
	        //deque = new LinkedList<Integer>();
	    	queue= new LinkedList<Integer>();
	    }
	    public void push(int x) {
	        //deque.add(x); 
	    	int size = queue.size();
	    	queue.add(x);
	    	for(int i=0;i<size;i++) {
	    		queue.add(queue.poll());
	    	}
	    }
	    public int pop() {
	        //return deque.removeLast(); 
	    	return queue.poll();
	    }
	    public int top() {
	        //return deque.peekLast();  
	    	return queue.peek();
	    }	    
	    public boolean empty() {
	        //return deque.size()==0;
	    	return queue.size()==0;
	    }   
	    public static void main(String[] args) {
		   StackUsingQueue stack = new StackUsingQueue();
		   stack.push(3);
		   stack.push(4);
		   stack.push(5);
		   System.out.println("Pop: "+stack.pop());
		   stack.push(6);
		   System.out.println("Pop: "+stack.top());  
	   }
}
