package dataStructures.Stack;

import java.util.*;
public class StackUsngCollections {
	public static void main() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
        System.out.println("The top element is " + stack.peek());
 
        stack.pop();        
        stack.pop();       
        System.out.println("The stack size is " + stack.size());
 
        // check if the stack is empty
        if (stack.empty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
	}
}
