import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/60059?language=python3
 * 
 * @author 15com
 *
 */
public class ÀÚ¹°¼è¿Í¿­¼è {
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		boolean answer = false;

		int[][] map = new int[lock.length * 3][lock.length * 3];

		for (int i = map.length / 3; i < map.length / 3 + lock.length; i++) {
			for (int j = map.length / 3; j < map.length / 3 + lock.length; j++) {
				map[i][j] = lock[i - lock.length][j - lock.length];
			}
		}

		for (int ro = 0; ro < 4; ro++) {

			for (int i = 0; i < map.length - key.length; i++) {
				for (int j = 0; j < map.length - key.length; j++) {
					int[][] new_map = new int[map.length][map.length];
					for (int r = 0; r < new_map.length; r++) {
						for (int c = 0; c < new_map.length; c++) {
							new_map[r][c] = map[r][c];
						}
					}
					for (int row = 0; row < key.length; row++) {
						for (int col = 0; col < key.length; col++) {
							new_map[i + row][j + col] += key[row][col];
						}
					}
//					for (int j2 = 0; j2 < new_map.length; j2++) {
//						System.out.println(Arrays.toString(new_map[j2]));
//					}
//					System.out.println("--");
					if (unlock(new_map, lock)) {
						System.out.println("true");
						answer = true;
						return;
//						return answer;
					}
				}
			}
			key = rotate90(key);

		}
	}

	private static boolean unlock(int[][] map, int[][] lock) {

		for (int i = map.length / 3; i < map.length / 3 + lock.length; i++) {
			for (int j = map.length / 3; j < map.length / 3 + lock.length; j++) {
				if (map[i][j] != 1)
					return false;
			}
		}

		return true;
	}

	private static int[][] rotate90(int[][] key) {

		int[][] new_key = new int[key.length][key.length];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				new_key[j][key.length - i - 1] = key[i][j];
			}
		}
		return new_key;
	}

}
