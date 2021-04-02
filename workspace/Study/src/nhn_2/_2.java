package nhn_2;

import java.util.Scanner;

class _2 {
	static int siment;

	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		int[] map = new int[width];
		siment = 0;
		for (int i = 0; i < day; i++) {
			for (int j = 0; j < width; j++) {
				map[j] += blocks[i][j];
			}

			boolean check[] = new boolean[width];
			for (int j = 0; j < map.length; j++) {
				if (!check[j])
					dfs(j, map, check, j);
			}
		}

		System.out.println(siment);
	}

	private static void dfs(int idx, int[] map, boolean[] check, int start) {
		// TODO Auto-generated method stub

		check[idx] = true;

		if (idx == 0 || idx == map.length - 1) {
			return;
		}

		if (idx < map.length - 1 && map[idx + 1] > map[idx]) {
			dfs(idx + 1, map, check, start);
		}

		if (map[idx - 1] < map[idx] && map[idx + 1] > map[idx]) {
			boolean ok = false;
			int save = -1;
			for (int i = idx - 1; i > 0; i++) {
				if (map[i] < map[i - 1]) {
					ok = true;
					save = i - 1;
					break;
				}
			}
			if (ok) {
				if (map[save] >= map[idx + 1]) {
					siment += map[idx + 1] - map[idx];
					map[idx] = map[idx + 1];
				} else {
					siment += map[save] - map[idx];
					map[idx] = map[save];
				}
			}
		}

		else if (check[idx - 1] && check[idx + 1] && map[idx - 1] < map[idx] && map[idx + 1] < map[idx]) {
			boolean ok = false;
			int save = -1;
			for (int i = idx + 1; i < map.length - 1; i++) {
				if (map[i] < map[i + 1]) {
					ok = true;
					save = i + 1;
					break;
				}
			}
			if (ok) {
				if (map[save] >= map[idx - 1]) {
					siment += map[idx - 1] - map[idx];
					map[idx] = map[idx - 1];
				} else {
					siment += map[save] - map[idx];
					map[idx] = map[save];
				}
			}
		}

		else {
			boolean ok1 = false;
			int save1 = -1;
			for (int i = idx; i > 0; i--) {
				if (map[i] < map[i - 1]) {
					ok1 = true;
					save1 = i - 1;
					break;
				}
			}
			boolean ok2 = false;
			int save2 = -1;
			for (int i = idx; i < map.length - 1; i++) {
				if (map[i] < map[i + 1]) {
					ok2 = true;
					save2 = i + 1;
					break;
				}
			}
			if (ok1 && ok2 && map[save1] >= map[save2]) {
				siment += map[save2] - map[idx];
				map[idx] = map[save2];
			} else if (ok1 && ok2 && map[save1] < map[save2]) {
				siment += map[save1] - map[idx];
				map[idx] = map[save1];
			}

			else if (map[idx + 1] >= map[idx - 1]) {
				siment += map[idx + 1] - map[idx];
				map[idx] = map[idx + 1];
			} else if (map[idx + 1] < map[idx - 1]) {
				siment += map[idx - 1] - map[idx];
				map[idx] = map[idx - 1];
			}
		}

	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}