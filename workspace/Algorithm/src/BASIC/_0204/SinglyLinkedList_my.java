package BASIC._0204;

class MyLinkedList {
	static class Node {
		int data;
		Node link;
	}

	Node head;
	int size = 0;

	void addToFirst(int data) {
		size++;
		Node newNode = new Node();
		newNode.data = data;

		if (head == null)
			head = newNode;
		else {
			newNode.link = head;
			head = newNode;
		}
	}

	void addToLast(int data) {
		size++;
		Node newNode = new Node();
		newNode.data = data;

		Node cur = head;

		if (head == null)
			head = newNode;
		else {
			while (cur.link != null)
				cur = cur.link;
			cur.link = newNode;
		}
	}

	void add(int idx, int data) {
		// 넣으려고 하는 idx가 유효하지 않으면 return;
		if (idx > size || idx < 0)
			return;
		// 넣으려는 위치가 0인 경우 -> addToFirst
		if (idx == 0)
			addToFirst(data);
		// 넣으려는 위치가 size번인 경우-> addToLast
		else if (idx == size)
			addToLast(data);
		// 둘 다 아닌 경우, 앞의 것을 찾음
		else {
			// 새로운 노드 객체를 생성하고 data 저장
			size++;
			Node newNode = new Node();
			newNode.data = data;

			Node cur = get(idx - 1);
			newNode.link = cur.link;
			cur.link = newNode;
		}
	}

	void delete(int idx) {
		if (idx >= size || size < 1 || idx < 0)
			return;
		
		//첫번째꺼를 지우는 경우 head의 link를 head로 변경
		if (idx == 0)
			head = get(idx+1);
		//그 외의 경우 idx-1번째 노드를 찾아옴
		else {
			Node pre = get(idx - 1);
			Node next = get(idx + 1);

			pre.link = next;
		}
	}

	Node get(int idx) {
		// idx번째 노드를 리턴
		if (idx >= size || idx < 0)
			return null;

		Node cur = head;
		for (int i = 0; i < idx; i++)
			cur = cur.link;

		return cur;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while(tmp != null) {
			sb.append(tmp.data).append(" ");
			tmp = tmp.link;
		}
		return sb.toString();
	}

}

public class SinglyLinkedList_my {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addToFirst(10);
		list.addToLast(20);
		list.addToLast(30);
		list.add(1, 40);
		System.out.println(list);
		//10 40 20 30
	}

}
