package dataStructures.linkedList;

import dataStructures.linkedList.DeleteNodeInLinkedList.ListNode;

public class DeleteNthNodeFromEnd {
	class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode temp = head;
	        ListNode prev = head;
	        while(n>=1 && temp.next!=null){
	            temp =temp.next;
	            n=n-1;
	        }
	        while(temp.next!=null){
	            temp=temp.next;
	            prev=prev.next;
	        }
	        if(n>=1){
	            return head.next;
	        }
	        else{
	            prev.next = prev.next.next;
	            return head;
	        }
	    }
	}
    

}
