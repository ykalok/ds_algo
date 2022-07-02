package dataStructures.Stack;

public class StackUsingArray {
	private int arr[];
	private int capacity;
	private int top;
	
	// Constructor to initialize the stack
	public StackUsingArray(int size) {
		arr = new int[size];
		capacity=size;
		top =-1;
	}
	
	
	public void push(int x) {
		 if (isFull())
	        {
	            System.out.println("Overflow\nProgram Terminated\n");
	            System.exit(-1);
	        }
	 
	        System.out.println("Inserting " + x);
	        arr[++top] = x;
	}
	
	public int pop() {
		if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
	 
		System.out.println("Removing " + peek());
        return arr[top--];
	}
	
	public int peek() {
		if (!isEmpty()) {
            return arr[top];
        }
        return -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if(top==capacity-1)
			return true;
		return false;
	}
	
	public static void main (String[] args)
    {
		StackUsingArray stack = new StackUsingArray(3);
 
        stack.push(1);      
        stack.push(2);      
 
        stack.pop();        
        stack.pop();        
        stack.push(3);    
 
        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());
 
        stack.pop();        
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
	

}
