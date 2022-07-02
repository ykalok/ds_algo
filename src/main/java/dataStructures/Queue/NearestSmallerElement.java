package dataStructures.Queue;

import java.util.Stack;

import dataStructures.Stack.NextSmallestElement;

public class NearestSmallerElement {


	public int[] nearestSmallestElement(int[] nums) {
        int n=nums.length;
        int arr[] = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<n;i++){
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
		NearestSmallerElement nse= new NearestSmallerElement();
		int arr []=nse.nearestSmallestElement(new int[]{2,4,1,6,6});
		for(int x:arr)
			System.out.print(x+" ");

	}




}
