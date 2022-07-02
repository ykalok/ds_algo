package dataStructures.Queue;

import java.util.Stack;

public class QueueUsingStack {
	    private Stack<Integer> stack1;
	    private Stack<Integer> stack2;
	    
	    public QueueUsingStack() {
	        stack1 = new Stack<Integer>();
	        stack2 = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        while(!stack1.isEmpty()){
	            stack2.push(stack1.peek());
	            stack1.pop();
	        }
	        stack1.push(x);
	        while(!stack2.isEmpty()){
	            stack1.push(stack2.peek());
	            stack2.pop();
	        }
	    }
	    
	    public int pop() {
	        int x=stack1.peek();
	        stack1.pop();
	        return x;
	    }
	    
	    public int peek() {
	        
	        return stack1.peek();
	        
	    }
	    
	    public boolean empty() {
	        return stack1.size()==0;
	    }
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.push(1);
		queue.push(2);
		queue.push(4);
		System.out.println("pop: "+ queue.pop());
		System.out.println("Peek: "+ queue.peek());
		queue.push(3);

	}

}
