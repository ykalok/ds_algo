package dataStructures.Stack;

import java.util.Stack;

public class SortStack {
	public Stack<Integer> sortAStack(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			if (temp.isEmpty()) {
				temp.push(stack.pop());
			} else {
				int data = stack.pop();
				while (!temp.isEmpty() && temp.peek() > data) {
					stack.push(temp.pop());
				}
				temp.push(data);
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		SortStack st = new SortStack();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(6);
		Stack<Integer> temp = st.sortAStack(stack);
		while(!temp.isEmpty()) {
			System.out.println(temp.pop()+" ");
		}
		
	}
}
