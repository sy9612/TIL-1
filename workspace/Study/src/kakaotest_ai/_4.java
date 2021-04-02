package kakaotest_ai;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class _4 {
	static class Node {
		String i;
		int j;

		Node(String i, int j) {
			this.i = i;
			this.j = j;
		};
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		String[][] all = new String[M][3];
		
		for (int i = 0; i < M; i++) {
			all[i] = br.readLine().split(" ");
		}
		
		int Q = Integer.parseInt(br.readLine());
		String[][] qt = new String[Q][3];
		for (int i = 0; i < Q; i++) {
			qt[i] = br.readLine().split(" ");
		}
		
		for (int i = 0; i < Q; i++) {
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(qt[i][0],0));
			
			int min = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				Node buf = q.poll();
				
				if(buf.i.equals(qt[i][1])) {
					min = Math.min(min, buf.j);
					continue;
				}
				
				for (int j = 0; j < M; j++) {
					if(buf.i.equals(all[j][0])) {
						q.add(new Node(all[j][1], buf.j + Integer.parseInt(all[j][2])));
					}
				}
				
			}
			if(min == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(min);
		}
		
		
	}
}
