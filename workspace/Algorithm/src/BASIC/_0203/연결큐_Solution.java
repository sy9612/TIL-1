package BASIC._0203;

class Node {
	String data;
	Node link;
}
class LinkedQueue{
	//관련있는 변수들과 함수들을 모아 자료형으로 생성
	Node front;
	Node rear;
	void printAll() {
		//front부터 시작해서 맨 마지막 원소까지 빠짐없이 출력
		Node cur = front;
		while(cur != null) {
			System.out.println(cur.data);
			cur = cur.link;
		}
	}
	
	void enQueue(String data) {
		Node node = new Node();
		node.data = data;
		if (front == null && rear == null) {
			front = node;
			rear = node;
		} else {
			// 현재 rear가 가리키고 있는 것의 다음 위치에 새로운 것을 기억시키고 rear를 바꿈
			rear.link = node;
			rear = node;
		}
	}

	String deQueue() {
		String ret = null;
		// 큐가 비었으면 큐가 비었다고 출력
		if (front == null && rear == null)
			System.out.println("Empty");
		// 큐가 안비었으면
		else {
			ret = front.data;
			front = front.link;
			if (front == null)
				rear = null;
		}

		return ret;
	}
}

public class 연결큐_Solution {
	static Node front;
	static Node rear;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue queue = new LinkedQueue();
		queue.enQueue("A");
		queue.enQueue("B");
		queue.enQueue("C");
		
		System.out.println(queue.deQueue());
		queue.enQueue("D");


		queue.printAll();
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());

		
	}



}
