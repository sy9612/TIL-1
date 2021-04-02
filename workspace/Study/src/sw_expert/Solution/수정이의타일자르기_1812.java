package sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 수정이의타일자르기_1812 {

	static class Rectangle {
		int min;
		int max;

		public Rectangle(int width, int height) {
			if(width<height) {
				min = width;
				max = height;
			}
			else {
				min = height;
				max = width;
			}
		};
		
		
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
		
	}
	static int N, M, size[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cnt = 0;
			size = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			}//만들고자하는 정사각형의 크기(2^K) 입력(K)
			
			cut();
		}
	}
	static PriorityQueue<Rectangle> queue;
	static int cnt;
	private static void cut() {
		// TODO Auto-generated method stub
		// 가장 큰 크기의 정사각형부터 만들기
		Arrays.sort(size);
		queue = new PriorityQueue<>();
		queue.add(new Rectangle(N, M));
		cnt++;
		
		for(int i= N-1; i>=0; i--) {
			go(1 << size[i]); //크기 계산
		}
	
	}
	private static void go(int size) {
		// queue에서 poll() : min값이 최대인 직사각형이 뽑아짐
		// 직사각형의 최소변의 길이가 size보다 같거나 크면 원하는 크기의 정사각형을 만들 수 있음
		Rectangle r = queue.poll();
		if(r.min == size) {
			queue.offer(new Rectangle(r.min-size, size));
			queue.offer(new Rectangle(r.min, r.max-size));
		}
		// 아니면: 원하는 크기의 정사각형을 만들 수 없음
		else {
			queue.offer(r);
			queue.offer(new Rectangle(M-size, size));
			queue.offer(new Rectangle(M, M-size));
			++cnt;
		}
	}
}
