package BASIC._0203;

import java.util.Scanner;

public class 선형큐_Solution {
	//1차원 배열 하나의 front와 rear 커서로 사용할 변수 준비
		//enQueue는 rear+1 시키고 rear 위치에 데이터를 삽입 -> rear는 지금까지 중 마지막에 들어온 원소의 위치
		//deQueue는 front+1 시키고 front위치의 데이터를 인출 -> front는 지금까지 중 마지막에 인출했던 원소의 위치
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] queue = new int[10];
			int front = -1;
			int rear = -1;
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("1. enQueue\n2. deQueue\n3. size\n4. peek\n0.end");
				int sel = sc.nextInt();
				if(sel == 0)
					break;
				else if(sel == 1) {
					int data = sc.nextInt();
					queue[++rear] = data;
				}
				else if(sel == 2) {
					if(front == rear)
						System.out.println("Empty queue");
					else
						System.out.println(queue[++front]);
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
