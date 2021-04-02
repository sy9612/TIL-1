package BASIC._0203;

import java.util.Scanner;

public class 원형큐 {
	static int size = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue = new int[2];
		int front = 0;
		int rear = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. enQueue\n2. deQueue\n3. size\n4. peek\n0. end");
			int sel = sc.nextInt();
			if(sel == 0)
				break;
			else if(sel == 1) {
				int data = sc.nextInt();
				rear += 1;
				rear %= size;
				queue[rear] = data;
			}
			else if(sel == 2) {
				if(front == rear)
					System.out.println("Empty queue");
				else {
					front %= size;
					front += 1;
					System.out.println(queue[front]);
				}
			}
			else if(sel == 3) {
				System.out.println("Size: " + (rear - front));
			}
			else if(sel == 4) {
				//다음 번에 읽을 것이 무엇인지 확인
				System.out.println(queue[front+1]);
			}
		}
	}
}
