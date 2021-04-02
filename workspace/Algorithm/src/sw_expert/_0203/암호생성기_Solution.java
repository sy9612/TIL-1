package sw_expert._0203;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();

			//큐에 여덟개의 숫자를 넣은 후
			for(int i =0; i<8; i++) {
				queue.offer(sc.nextInt());
			}

			//디큐 해서 나온 값을 i 빼고 인큐
			//위의 값이 0보다 작아지면 0으로 인큐 아니면 그냥 인큐
			
			int i= 1;
			while(true) {
				int n = queue.poll();
				n = (n-i);
				if(n<=0) {
					queue.offer(0);
					break;
				}
				//아니면 그냥 인큐(반복)
				queue.offer(n);
				i++;
				if(i==6)
					i = 1;
			}
			System.out.print("#" + tc + " ");
			while(!queue.isEmpty())
				System.out.print(queue.poll() + " ");
			System.out.println();
		}
	}

}
