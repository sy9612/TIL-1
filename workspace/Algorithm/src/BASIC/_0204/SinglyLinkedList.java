package BASIC._0204;

class Node{
	int data; //데이터 공간
	Node link; //link 공간
}

public class SinglyLinkedList {

	public static void main(String[] args) {
		
		Node head = new Node();
		head.data = 10;
		
		
		Node n2 = new Node();
		n2.data = 20;
		head.link = n2;
		
		Node n3 = new Node();
		n3.data = 30;		
		n2.link = n3;
		
		Node n4 = new Node();
		n4.data = 40;		
		n3.link = n4;
		
		n2 = n3 = n4 = null;
		
		
		//첫번째 원소에 추가
		Node n5 = new Node();
		n5.data = 50;
		
		n5.link = head; //맨 앞에 있던 것을 다음으로
		head = n5; //맨 처음으로 세팅
		n5 = null; //해당 변수는 더 이상 필요하지 않음
		
		Node n6 = new Node();
		n6.data = 60;
		//n6 마지막에 추가		
		Node cur = head;
		while(cur.link !=null)
			cur = cur.link;
		cur.link = n6;
		n6 = null;
		
		//head가 가리키는 원소부터 시작해서, 마지막 원소까지 차례대로 출력
		cur = head;
		while(cur!= null) {
			System.out.println(cur.data);
			cur = cur.link;
		}
	
	}

}
