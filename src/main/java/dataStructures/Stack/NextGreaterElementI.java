package dataStructures.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int len = nums1.length;
        int arr[] = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],stack.peek());
            }
            stack.push(nums2[i]);
        }
        for(int i=0;i<len;i++){
            arr[i]=map.get(nums1[i]);
        }
        return arr;  
    }
	public static void main(String[] args) {
		NextGreaterElementI nge= new NextGreaterElementI();
		int arr []=nge.nextGreaterElement(new int[]{2, 4},new int[]{2,4,5,6,6});
		int n=arr.length;
		for(int x:arr)
			System.out.print(x+" ");

	}

}
