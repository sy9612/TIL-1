package baekjoon._0203;

import java.util.LinkedList;
import java.util.Queue;

public class 요세푸스순열_Solution_큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//큐에서 꺼내서 카운트를 센다.
		//카운트가 K번째가 아니면, 다시 큐에 넣는다.
		//카운트가 K번째면 출력한다.
		
		int[] arr = {1,2,3,4,5,6,7};
		int K = 3;
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i<arr.length; i++)
		{
			queue.offer(arr[i]); //offer = add;
		}
		int cnt = 0;
		while(!queue.isEmpty()) {
			cnt++;
			int num = queue.poll();
			if(cnt!=K)
				queue.offer(num);
			else {
				System.out.println(num);
				cnt = 0;
			}
		}
	}
}
