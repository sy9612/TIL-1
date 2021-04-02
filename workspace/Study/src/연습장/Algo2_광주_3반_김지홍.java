package 연습장;

import java.util.Scanner;

public class Algo2_광주_3반_김지홍 {
	private static int R;
	private static int C;
	private static char[][] map;
	private static int N;
	private static int[] F;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("# " + tc + " ");
			R = sc.nextInt(); //세로
			C = sc.nextInt(); //가로

			map = new char[R][C]; //맵

			//맵 입력
			for (int i = 0; i < R; i++) {
				String st = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = st.charAt(j);
				}
			}

			N = sc.nextInt(); //화산탄 개수
			F = new int[N]; 
			//떨어뜨릴 화산탄 열
			for (int i = 0; i < F.length; i++) {
				F[i] = sc.nextInt() - 1;
			}
			
			//열만큼 반복
			for (int f = 0; f < F.length; f++) {
				checkO(0, F[f]);
			}
			print(map);
		}
	} // end main

	private static void checkO(int rr, int f) {
		// TODO Auto-generated method stub
		
		//화산탄 체크
		for (int r = rr; r < R; r++) {
			//끝까지 도달했을 때 화산탄이 없는 경우
			if (r == R - 1 && map[r][f] == '.') {
				map[r][f] = 'O';
				break;
			}
			//막혀있는 경우
			else if (map[r][f] == 'X') {
				if (r - 1 >= 0) //화산탄을 놓을 수 있으면
					map[r - 1][f] = 'O';
				break;
			} else if (map[r][f] == '.') { //끝이 아닌데 빈 공간인 경우
				continue; //계속 진행
			} else if (map[r][f] == 'O') { //화산탄이 놓여있는 경우
				if (f - 1 >= 0 && r  < R && map[r][f - 1] == '.' && map[r-1][f-1] == '.') {
					checkO(r, f-1); //왼쪽과 왼쪽아래가 비어있을 때 체크
				} 
				else if (f + 1 < R && r < R && map[r][f + 1] == '.' && map[r-1][f+1] == '.') {
					checkO(r,f+1); //오른쪽과 오른쪽 아래가 비어있을 때 체크
				} 
				else if (r - 1 >= 0) {
					map[r - 1][f] = 'O'; //모두 아니면 바로 위쪽애 화산탄 놓음
				}

				break;
			}
		}
	}

	//출력
	private static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
