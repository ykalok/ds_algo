package dataStructures.linkedList;

public class LinkedListCrud {
	public Node head;
	public static class Node{
		public int data;
		public Node next;
		
		Node(int d){
			data= d;
			next = null;
		}
	}
	
	//*********************INSERTION***************************//
	//Method to insert a new node 
	public static LinkedListCrud insert(LinkedListCrud list,int data) {
		//create a new node of given data
		Node newNode= new Node(data);
		newNode.next= null;
		//if linked list is empty then make newNode as head
		if(list.head==null) {
			list.head=newNode;
		}
		else {
			//traverse till the last node and insert the newNode there 
			Node last = list.head;
			while(last.next!=null) {
				last= last.next;
			}
			//Insert the newNode at last node
			last.next=newNode;
		}
		return list;
	}
	
	//*********************DELETION BY KEY***************************//
	//Method to delete a node in LinkedList by key
	public static LinkedListCrud deleteBykey(LinkedListCrud list, int key) {
		//Store head node
		Node currNode=list.head,prev=null;
		//Case 1:
		//if head node itself holds the to be deleted
		if(currNode!=null && currNode.data==key) {
			list.head = currNode.next;
			//Display message 
			System.out.println(key +" found and deleted");
			return list;	
		}
		
		//Case 2:
		//if the key is somewhere other than at head
		while(currNode!=null && currNode.data !=key) {
			prev = currNode;
			currNode=currNode.next;
		}
		if(currNode!=null) {
			prev.next = currNode.next;
			System.out.println(key +" found and deleted");
		}
		
		//Case 3: key is not present
		if(currNode==null)
		{
			System.out.println(key +" is not found");
		}
		return list;
		
	}
	
	//*********************DELETION AT POSITION***************************//
	//Method to delete a node in LinkedList by position
		public static LinkedListCrud deleteAtPosition(LinkedListCrud list, int index) {
			//Store head node
			Node currNode=list.head,prev=null;
			//Case 1:
			//if index is 0 , then head node itself to be deleted
			if(index==0 && currNode!=null) {
				list.head = currNode.next;
				//Display message 
				System.out.println(index +" position element deleted");
				return list;	
			}
			
			//Case 2:
			//if the index greater than 0 and less than the size of Linked list
			int count=0;
			while(currNode!=null ) {
				if(count==index) {
					prev.next = currNode.next;
					System.out.println(index +" position element deleted");
					break;
				}else {
					prev = currNode;
					currNode=currNode.next;
					count++;
				}
			}
			
			//Case 3: Index is greater than the size of linked list
			if(currNode==null)
			{
				System.out.println(index +" position element not found");
			}
			return list;
			
		}	
		

	
	//*********************TRAVERSAL***************************//
	//Method to print the LinkedList.
	public static void printLL(LinkedListCrud list) {
		Node CurrNode = list.head;
		System.out.print("LinkedList: ");
		while(CurrNode!=null) {
			System.out.print(CurrNode.data+" ");
			CurrNode=CurrNode.next;
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCrud list = new LinkedListCrud();
		//Insertion
		//insert the values
		list = insert(list,1);
		list = insert(list,2);
		list = insert(list,3);
		list = insert(list,4);
		list = insert(list,5);
		list = insert(list,6);
		list = insert(list,7);
		list = insert(list,8);
		printLL(list);
		
		//Deletion by key
		//delete head;
		System.out.println ("Deletion by Key: ");
		deleteBykey(list, 1);
		printLL(list);
		
		//delete middle value
		deleteBykey(list, 4);
		printLL(list);
		
		//delete value is not present
		deleteBykey(list, 10);
		printLL(list);
		
		//Deletion by position
		//delete position 0;
		
		System.out.println ("Deletion at Position: ");
		deleteAtPosition(list, 0);
		printLL(list);
		
		//delete middle position
		deleteAtPosition(list, 4);
		printLL(list);
		
		//delete position is not present
		deleteAtPosition(list, 10);
		printLL(list);
	}

}
