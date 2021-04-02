package sw_expert;

import java.util.Scanner;

public class 상호의_배틀필드_1873 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();

			char map[][] = new char[H][W];
			int car[] = new int[2];
			for (int i = 0; i < H; i++) {
				String buf = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = buf.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						car[0] = i;
						car[1] = j;
					}
				}
			}

			int N = sc.nextInt();

			String command = sc.next();

			int[] com = new int[command.length()];
			for (int i = 0; i < com.length; i++)
				com[i] = command.charAt(i);

			for (int i = 0; i < com.length; i++) {
				switch (com[i]) {
				case 'U':
					map[car[0]][car[1]] = '^';
					if (car[0] - 1 >= 0 && map[car[0] - 1][car[1]] == '.') {
						map[car[0]][car[1]] = '.';
						car[0]--;
						map[car[0]][car[1]] = '^';
					}
					break;
				case 'D':
					map[car[0]][car[1]] = 'v';
					if (car[0] + 1 < H && map[car[0] + 1][car[1]] == '.') {
						map[car[0]][car[1]] = '.';
						car[0]++;
						map[car[0]][car[1]] = 'v';
					}
					break;
				case 'L':
					map[car[0]][car[1]] = '<';
					if (car[1] - 1 >= 0 && map[car[0]][car[1] - 1] == '.') {
						map[car[0]][car[1]] = '.';
						car[1]--;
						map[car[0]][car[1]] = '<';
					}
					break;
				case 'R':
					map[car[0]][car[1]] = '>';
					if (car[1] + 1 < W && map[car[0]][car[1] + 1] == '.') {
						map[car[0]][car[1]] = '.';
						car[1]++;
						map[car[0]][car[1]] = '>';
					}
					break;
				case 'S':
					int h_car = car[0];
					int w_car = car[1];
					switch (map[car[0]][car[1]]) {
					case '^':
						
						while (true) {
							if (( (h_car - 1 >= 0) && map[h_car - 1][car[1]] == '.')|| (h_car - 1 >= 0 && map[h_car - 1][car[1]] == '-'))
								h_car--;
							else if ( (h_car - 1 >= 0) && map[h_car - 1][car[1]] == '*') {
								map[h_car-1][car[1]] = '.';
								break;
							} else
								break;
						}
						break;
					case 'v':
						while (true) {
							if (((h_car + 1) <H && map[h_car + 1][car[1]] == '.')|| ((h_car + 1) <H  && map[h_car +1][car[1]] == '-'))
								h_car++;
							else if (h_car + 1 <H && map[h_car + 1][car[1]] == '*') {
								map[h_car+1][car[1]] = '.';
								break;
							} else
								break;
						}
						break;
					case '<':
						while (true) {
							if ((w_car - 1 >= 0 && map[car[0]][w_car-1] == '.')|| (w_car - 1 >= 0 && map[car[0]][w_car-1] == '-'))
								w_car--;
							else if (w_car - 1 >= 0 && map[car[0]][w_car-1] == '*') {
								map[car[0]][w_car-1] = '.';
								break;
							} else
								break;
						}
						break;
					case '>':
						while (true) {
							if ((w_car + 1 <W && map[car[0]][w_car+1] == '.')|| (w_car + 1 <W && map[car[0]][w_car+1] == '-'))
								w_car++;
							else if (w_car + 1 <W && map[car[0]][w_car+1] == '*') {
								map[car[0]][w_car+1] = '.';
								break;
							} else
								break;
						}
						break;
					}
				}
			}

			System.out.print("#" + tc + " ");
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}

