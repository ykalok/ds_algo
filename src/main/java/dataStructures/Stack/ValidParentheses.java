package dataStructures.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Map<Character,Character> map = new HashMap<Character, Character>();
		map.put(')','(');
		map.put('}','{');
		map.put(']','[');
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				if( stack.isEmpty() || map.get(s.charAt(i))!=stack.pop()){
					return false;
				}
			}else {
				stack.push(s.charAt(i));
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		ValidParentheses valid= new ValidParentheses();
		System.out.println(valid.isValid("{{{}}}()"));
		// TODO Auto-generated method stub

	}

}
