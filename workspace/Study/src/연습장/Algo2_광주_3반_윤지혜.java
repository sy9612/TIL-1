package 연습장;

import java.util.Scanner;

public class Algo2_광주_3반_윤지혜 {
	static int T, r, c, n;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= tc; tc++) {
			r = sc.nextInt();
			c = sc.nextInt();
			map = new char[r][c];

			for (int i = 0; i < r; i++) {
				String tmp = sc.next();
				for (int j = 0; j < c; j++) {
					map[i][j] = tmp.charAt(j); // 초기 map 받아오기
				}
			}
			n = sc.nextInt(); // 날아올 화산탄 횟수

			for (int i = 0; i < n; i++) { // . : 빈칸 , X : 장애물
				int dr = 0;
				int dc = sc.nextInt() - 1;// 떨어질 열 !
				map[dr][dc] = 'O'; // 떨어질 칸 !
				for (int nr = 1; nr < r; nr++) {
					if (map[nr][dc] == '.') { // 아래칸 비었으면 아래 칸으로 굴러 떨어짐
						map[dr][dc] = '.';
						map[nr][dc] = 'O';
						dr = nr;
					} else if (map[nr][dc] == 'O') { // 아래칸에 굳은 화산탄이 있다면
						if (dc - 1 >= 0 && nr < r && map[nr][dc - 1] == '.'
								) { // 화산탄 왼쪽 + 왼쪽아래칸 비었으면 -> 왼쪽 아래칸으로 굴러 떨어짐
							map[dr][dc] = '.';
							
							if(nr == r-1)
								map[nr][dc-1] = 'O';
							else if(nr+1 < r && map[nr+1][dc-1] == '.') map[nr + 1][dc - 1] = 'O';
							
							dr = nr;
						} else if (dc + 1 < c && nr < r &&  map[nr][dc + 1] == '.'
								) {// 왼쪽 굴러 떨어지지 않았고 , 오른쪽 + 오른쪽 아래 칸 비었다면 -> 오른쪽 아래칸으로 굴러
																// 떨어짐!
							map[dr][dc] = '.';
							
							if(nr == r-1)
								map[nr][dc+1] = 'O';
							else if(nr+1 < r && map[nr+1][dc+1] == '.') map[nr + 1][dc + 1] = 'O';
							dr = nr;
						} else {// 위 두 경우 아니면 화산탄 멈추고 다시 움직임 x
							break;
						}
					} else if (map[nr][dc] == 'X' || nr == r - 1) {// 장애물이거나, 가장 아래 땅이면 화산탄 멈춤
						break;
					}

				

				}

			}
			// 출력
			System.out.println("# " + tc);
			for (int rr = 0; rr < r; rr++) {
				for (int cc = 0; cc < c; cc++) {
					System.out.print(map[rr][cc]);
				}
				System.out.println();
			}
		}
	}
}