package sw_expert._0121;
import java.util.Scanner;


public class Ladder {
	static int MAX = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			sc.nextInt(); //입력되는 테스트케이스의 번호, 어차피 반복계수 tc와 같은 값..
			int[][] map = new int[MAX][MAX];
			for(int i=0; i<MAX; i++) {
				for(int j=0; j<MAX; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//사다리 줄기의 번호들을 순차적으로 저장할 배열, 사다리 줄기의 최대 갯수는 맵의 크기 만큼(정확하게 알지 못함)
			int[] lanes = new int[MAX];
			//맨 아랫줄을 왼쪽부터 보면서 사다리 줄기가 발견될때마다 lanes배열에 순차적으로 저장
			//2가 표시되어있는 출구는 따로 기억
			int idx = 0;
			int goalIdx = 0;
			
			for(int j= 0; j<MAX; j++) {
				if(map[MAX-1][j] != 0) {
					if(map[MAX-1][j] == 2)
							goalIdx = idx;
					lanes[idx++] = j;
				}
			}
			int currentIdx = goalIdx;
			for(int i = MAX-1; i>=0; i--) {
				//왼쪽이 낭떠러지가 아니면서, 왼쪽에 1이 존재하면 currentIdx 하나 왼쪽으로 이동
				if(lanes[currentIdx] - 1 >=0 && map[i][lanes[currentIdx]-1] == 1)
					currentIdx--;
				else if(lanes[currentIdx] + 1 >=0 && map[i][lanes[currentIdx]+1] == 1)
					currentIdx++;
			}
			System.out.println("#"+tc+" "+lanes[currentIdx]);
		}
	}

}
