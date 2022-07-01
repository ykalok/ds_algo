package dataStructures.linkedList;

public class MergeTwoSortedLinkedList {
	public class ListNode {
		  int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	class Solution {
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	        
	        ListNode temp = new ListNode(0);
	        ListNode temp1 = temp;
	        while(list1!=null && list2!=null){
	            if(list1.val>list2.val){
	                temp1.next = list2;
	                list2=list2.next;
	            }
	            else{
	                temp1.next=list1;
	                list1=list1.next;
	            }
	            temp1=temp1.next;
	        }
	        if(list1==null)
	        {
	            temp1.next=list2;
	        }else{
	            temp1.next=list1;
	        }
	        
	        return temp.next;
//	         if(list1==null)
//	             return list2;
//	         if(list2==null)
//	             return list1;
//	         //ListNode node = new ListNode(0);
//	         if(list1.val<=list2.val){
//	             list1.next=mergeTwoLists(list1.next,list2);
//	         return list1;
//	         }
//	         else{
//	             list2.next =mergeTwoLists(list1,list2.next);
//	             return list2;
//	         }
	        
	        
	    }
	}

}
