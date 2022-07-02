package dataStructures.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueue {
	class MyStack {

	    private Deque<Integer> deque;
	    //private Queue<integer> q2;
	    public MyStack() {
	        deque = new LinkedList<Integer>();
	    }
	    
	    public void push(int x) {
	        deque.add(x); 
	    }
	    
	    public int pop() {
	        return deque.removeLast();  
	    }
	    
	    public int top() {
	        return deque.peekLast();
	        
	    }
	    
	    public boolean empty() {
	        return deque.size()==0;
	        
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */

}
