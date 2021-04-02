package baekjoon._0217;
import java.util.*;
public class 회의실배정_1931 {
	static class Pair implements Comparable<Pair>{
		int start;
		int end;
		@Override
		public int compareTo(Pair o) {
			
			if(this.end > o.end) {
				return 1;
			}
			else if(this.end < o.end) {
				return -1;
			}
			else {
				if(this.start < o.start)
					return -1;
				else if(this.start > o.start)
					return 1;
				else {
					return 0;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			Pair time = new Pair();
			time.start = sc.nextInt();
			time.end = sc.nextInt();
			list.add(time);
		}
		
		Collections.sort(list);
		
		
		int endtime = list.get(0).end;
		int result = 1;
		for(int i=1; i<N ;i++) {
			if(list.get(i).start >= endtime) {
				result++;
				endtime = list.get(i).end;
				
			}
		}
		System.out.println(result);
	}
	
}
