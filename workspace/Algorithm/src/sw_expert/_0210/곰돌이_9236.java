package sw_expert._0210;
import java.util.*;

class Node1 {
	int i;
	int j;
	Node1(int i, int j){
		this.i = i;
		this.j = j;
	}
}
public class 곰돌이_9236 {
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			char map[][] = new char[N][N];
			LinkedList<Node1> q = new LinkedList<>();
			
			Node1 Gomdol;
			Node1 Home;
			for(int i=0; i<N; i++) {
				String buf = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = buf.charAt(0);
					if(map[i][j] == 'H')
						q.add(new Node1(i,j));
					else if(map[i][j] == 'M')
						Gomdol = new Node1(i,j);
					else if(map[i][j] == 'D')
						Home = new Node1(i,j);
				}
			}
			
		}
	}

}
