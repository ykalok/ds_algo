package dataStructures.Queue;

public class QueueUsingArray {
	private int arr[];
	private int front;
	private int rear;
	private int count;
	private int capacity;
	
	public QueueUsingArray(int size) {
		arr = new int[size];
		front =0;
		rear=-1;
		capacity=size;
		count =0;
	}
	
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("Overflow\nProgram Terminated");
			System.exit(-1);
			
		}
		System.out.println("Inserting " + data);
		rear=(rear+1)%capacity;
		arr[rear]=data;
		count++;
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(-1);
			
		}
		int data = arr[front];
		front=(front+1)%capacity;
		count--;
		return data;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("UnderFlow\nProgram Terminated");
			System.exit(-1);
			
		}
		return arr[front];
	}
	
	public boolean isEmpty() {
		return (count==0);
	}
	
	public boolean isFull() {
		return (count==capacity);
	}
	
	public int size() {
        return count;
    }
	
	public static void main(String[] args) {
		
		QueueUsingArray queue = new QueueUsingArray(5);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println("Peek: "+queue.peek());
		queue.enqueue(4);
		
		System.out.println("Dequeue: "+queue.dequeue());
		queue.enqueue(5);
		System.out.println("Size: "+queue.size());
		queue.enqueue(6);
		queue.enqueue(7);
		
		
		
	}

}
