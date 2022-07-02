package dataStructures.Stack;

import java.util.Stack;

public class NextSmallestElement {

	public int[] nextSmallestElement(int[] nums) {
        int n=nums.length;
        int arr[] = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()>=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
            	arr[i]=-1;
            }else{
               arr[i]=stack.peek();
            }
            stack.push(nums[i]);
        }
        return arr;  
    }
	public static void main(String[] args) {
		NextSmallestElement nse= new NextSmallestElement();
		int arr []=nse.nextSmallestElement(new int[]{2,4,1,6,6});
		for(int x:arr)
			System.out.print(x+" ");

	}


}
