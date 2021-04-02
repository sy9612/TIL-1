package baekjoon._0217;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 회의실배정_Solution {
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		Meeting(int s, int e){
			start = s;
			end = e;
		}
		public int compareTo(Meeting o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end-o.end;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Meeting> queue = new PriorityQueue<>();
		for(int i=0; i<N; i++)
			queue.add(new Meeting(sc.nextInt(), sc.nextInt()));
		int lastFinishedTime = 0; // 최근 마지막에 끝난 회의의 시간을 기억할 변수
		int cnt = 0; //지금까지 개최된 회의의 개수
		while(!queue.isEmpty()) {
			//회의를 하나씩 꺼내면서, 최근 종료시간보다 일찍 시작하면 패스, 아니면 회의추가하고 종료시간 갱신
			Meeting meeting = queue.poll();
			if(lastFinishedTime <= meeting.start) {
				cnt++;
				lastFinishedTime = meeting.end;
			}
		}
		System.out.println(cnt);
	}

}
