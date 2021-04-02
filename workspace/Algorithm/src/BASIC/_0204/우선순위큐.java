package BASIC._0204;

class QMyLinkedList {
	static class Node {
		int data;
		Node link;
	}

	Node head;
	int size = 0;
	
	void enqueue(int data) {
		Node node = new Node();
		node.data = data;
		
		//리스트가 비어있으면 새로 만든 것을 헤드가 가리킴
		if(head == null)
			head = node;
		//헤드가 data보다 작을 때 
		else if(head.data > node.data) {
			node.link = head;
			head = node;
		}
		else {
			//head부터 검사
			//head의 다음이 null이면 head 다음에 붙으면 됨
			//head의 다음이 없을 떄, 그 다음 값이 new보다 작으면 한 칸 이동해서 검사
			//head
			
			Node tmp = head;
			Node tmp2 = head.link;
			while(tmp.link != null && tmp2.data < node.data)
			{
				tmp = tmp.link;
				tmp2 = tmp2.link;
			}
			
			node.link = tmp2;
			tmp.link = node;
			
		}
	}

	void add(int data) {
		// 넣으려고 하는 idx가 유효하지 않으면 return;

		// 새로운 노드 객체를 생성하고 data 저장
		size++;
		Node newNode = new Node();
		newNode.data = data;

		if (head == null)
			head = newNode;
		else {
			Node cur = head;
			Node prev = head;
			while (cur != null) {
				if (cur.data >= data) {
					if (cur == head) {
						newNode.link = cur;
						head = newNode;
						break;
					} else {
						prev.link = newNode;
						newNode.link = cur;
						break;
					}
				}
				prev = cur;
				cur = cur.link;
			}
			if (cur == null)
				prev.link = newNode;
		}

	}

	void delete(int idx) {
		if (idx >= size || size < 1 || idx < 0)
			return;

		// 첫번째꺼를 지우는 경우 head의 link를 head로 변경
		if (idx == 0)
			head = get(idx + 1);
		// 그 외의 경우 idx-1번째 노드를 찾아옴
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
		while (tmp != null) {
			sb.append(tmp.data).append(" ");
			tmp = tmp.link;
		}
		return sb.toString();
	}

}

public class 우선순위큐 {

	public static void main(String[] args) {
		QMyLinkedList list = new QMyLinkedList();
		list.add(1);
		list.add(4);
		list.add(0);
		System.out.println(list);
	}

}
