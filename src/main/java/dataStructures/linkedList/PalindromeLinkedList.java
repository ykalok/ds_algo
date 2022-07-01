package dataStructures.linkedList;

import dataStructures.linkedList.DeleteNodeInLinkedList.ListNode;

public class PalindromeLinkedList {
	class Solution {
	    public ListNode reverse(ListNode head){
	        if(head==null)
	            return head;
	        ListNode prev=null,curr=head;
	        while(curr!=null){
	            ListNode temp =curr.next;
	            curr.next = prev;
	            prev =curr;
	            curr=temp;
	        }
	        return prev;
	    }
	    public boolean isPalindrome(ListNode head) {
	        if(head.next==null)
	            return true;
	        ListNode slow =head;
	        ListNode fast =head;
	        while(fast.next!=null && fast.next.next!=null){
	            slow=slow.next;
	            fast=fast.next.next;  
	        }
	        ListNode temp = reverse(slow);
	        slow=head;
	        while(temp!=null && slow!=null){
	            if(temp.val!=slow.val){
	                return false;
	            }
	            temp= temp.next;
	            slow=slow.next;
	        }
	        return true;
	        
	    }
	}

}
