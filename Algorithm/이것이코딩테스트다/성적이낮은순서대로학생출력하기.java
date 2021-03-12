
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 성적이낮은순서대로학생출력하기 {
	static class Node implements Comparable<Node>{
		String name;
		int score;
		
		Node(String name, int score){
			this.name = name;
			this.score = score;
		}

		@Override
		public int compareTo(Node o) {

			if(this.score < o.score)
				return -1;
			else if(this.score == o.score)
				return 0;
			else
				return 1;
			
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Node> al = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			al.add(new Node(sc.next(), sc.nextInt()));
		}
		
		
		Collections.sort(al);
		
		for(Node i : al) {
			System.out.println(i.name);
		}
	}

}
