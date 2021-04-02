package kakaotest_ai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class _2 {
	static class Node implements Comparable<Node>{
		String team;
		int sscore;
		int ss = 0;

		Node(String team, int sscore) {
			this.team = team;
			this.sscore = sscore;
			this.ss = ssw[hs.get(team)] - ssl[hs.get(team)];
		};
		
		 @Override
	    public int compareTo(Node target) {
			if(this.sscore < target.sscore) {
				return 1;
			}
			else if(this.sscore == target.sscore) {
				
				
				if(this.ss > target.ss)
					return -1;
				else if(this.ss <target.ss)
					return 1;
				else {
					return this.team.compareTo(target.team);
				}
			}
			return -1;
	    }
	}
	private static int N;
	private static int[][] score;

	private static int[][] scorel;
	private static int[] finals;
	private static int[] ssw;
	private static int[] ssl;
	private static String[] team;
	private static HashMap<String, Integer> hs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 score = new int[N][N];
		 scorel = new int[N][N];
		 finals = new int[N];
		 ssw = new int[N];
		 ssl = new int[N];
		 team = new String[N];
		hs = new HashMap<>();

		int n = 0;
		for (int i = 0; i < N * (N - 1); i++) {
			String[] st = br.readLine().split(" ");
			int a =0;
			int b =0;
			if (!hs.containsKey(st[0])) {
				hs.put( st[0],n);
				a = n;
				n++;
			}
			if (!hs.containsKey(st[2])) {
				hs.put( st[2],n);
				b = n;
				n++;
			}
			
			if(Integer.parseInt(st[1]) >= Integer.parseInt(st[3])) {
				finals[hs.get(st[0])]++;
				ssw[hs.get(st[0])] += Integer.parseInt(st[1]);
				ssl[hs.get(st[0])] += Integer.parseInt(st[3]);
				
				ssw[hs.get(st[2])] += Integer.parseInt(st[3]);
				ssl[hs.get(st[2])] += Integer.parseInt(st[1]);
				
			}
			else {
				finals[hs.get(st[2])]++;
				ssw[hs.get(st[2])] += Integer.parseInt(st[3]);
				ssl[hs.get(st[2])] += Integer.parseInt(st[1]);
				
				ssw[hs.get(st[0])] += Integer.parseInt(st[1]);
				ssl[hs.get(st[0])] += Integer.parseInt(st[3]);
			}
			score[hs.get(st[0])][hs.get(st[2])] = Integer.parseInt(st[1]);
			scorel[hs.get(st[0])][hs.get(st[2])] = Integer.parseInt(st[3]);
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		Iterator<String> keys = hs.keySet().iterator();
        while (keys.hasNext()){
            String key = keys.next();
			q.add(new Node(key,finals[hs.get(key)]));
        }
        
        while(!q.isEmpty()) {
        	Node bb = q.poll();
        	System.out.println(bb.team + " " + bb.sscore + " " + bb.ss);
        }
	}
}
