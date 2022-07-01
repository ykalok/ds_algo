package dataStructures.linkedList;

import dataStructures.linkedList.DeleteNodeInLinkedList.ListNode;

public class DetectCycleInLinkedList {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if(head==null || head.next==null)
	            return false;
	        ListNode slow=head;
	        ListNode fast=head;
	        while(fast!=null && fast.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	            if(slow==fast)
	                return true;
	        }
	        return false;
	        
	    }
	}
//	public class Solution {
//	    public boolean hasCycle(ListNode head) {
//	        if(head==null || head.next==null)
//	            return false;
//	        ListNode curr=head;
//	        ListNode next1=head.next;
//	        while(next1.next!=null )
//	        {
//	            curr=curr.next;
//	            next1=next1.next;
//	            if(next1.next!=null){
//	                next1=next1.next;
//	            }
//	                
//	            if(curr==next1)
//	                return true;
//	        }
//	        return false;
//	        
//	    }
//	}

}
