package kakao_2020;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _6 {
	public static void main(String[] args) {

		int[][] board = { { 3, 0, 0, 2 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 2, 0, 0, 3 }

		};
		int r = 1;
		int c = 0;

		int answer = solution(board, r, c);
		System.out.println(answer);
	}

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int solution(int[][] board, int r, int c) {

		HashMap<Integer, Node> hm = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != 0) {
					if (hm.containsKey(board[i][j])) {
						hm.put(board[i][j] + 100, new Node(i, j));
						board[i][j] += 100;
					} else
						hm.put(board[i][j], new Node(i, j));
				}
			}
		}

		int total = 0;
		while (!hm.isEmpty()) {
			if (board[r][c] != 0) {
				int R;
				int C;
				int S = board[r][c];
				if (board[r][c] < 100) {
					R = hm.get(board[r][c] + 100).r;
					C = hm.get(board[r][c] + 100).c;
				} else {
					R = hm.get(board[r][c] - 100).r;
					C = hm.get(board[r][c] - 100).c;

				}
				hm.remove(S);
				if (S > 100) {
					S -= 100;
				} else {
					S += 100;
				}
				board[r][c] = 0;

				int totalcnt = 1;

				while (true) {
					if (r < R) {
						int cnt = 0;

						while (true) {
							r += 1;
							cnt++;
							if (board[r][c] == S) {
								cnt = 0;
							}
							if (board[r][c] != 0) {
								cnt = 1;
							}
							if (r >= board.length || r >= R) {
								break;
							}

						}

						if (cnt == 0)
							totalcnt += 1;
						else if (board.length - r <= cnt) {
							totalcnt += 1;
						}

						else {
							totalcnt += cnt;
						}

					} else if (r > R) {
						int cnt = 0;
						while (true) {
							r -= 1;
							cnt++;
							if (board[r][c] == S) {
								cnt = 0;
							}
							if (r < 0 || r <= R) {
								break;
							}
						}
						if (cnt == 0)
							totalcnt += 1;
						else if (r <= cnt) {
							totalcnt += 1;
						} else {
							totalcnt += cnt;
						}
					}

					if (c < C) {
						int cnt = 0;
						while (true) {
							c += 1;
							cnt++;
							if (board[r][c] == S) {
								cnt = 0;
							}
							if (board[r][c] != 0) {
								cnt = 1;
							}
							if (c >= board.length || c >= C) {
								break;
							}
						}
						if (cnt == 0)
							totalcnt += 1;
						else if (board.length - c <= cnt) {
							totalcnt += 1;
						} else {
							totalcnt += cnt;
						}
					} else if (c > C) {
						int cnt = 0;
						while (true) {
							c -= 1;
							cnt++;
							if (board[r][c] == S) {
								cnt = 0;
							}
							if (board[r][c] != 0) {
								cnt = 1;
							}
							if (c < 0 || c <= C) {
								break;
							}
						}
						if (cnt == 0)
							totalcnt += 1;
						else if (c <= cnt) {
							totalcnt += 1;
						} else {
							totalcnt += cnt;
						}
					}

					if (board[r][c] == S) {
						board[R][C] = 0;
						hm.remove(S);
						totalcnt++;
						break;
					}
				}

				total += totalcnt;
			} else { ////////////// else

				int min = Integer.MAX_VALUE;
				int RR = 0;
				int CC = 0;

				int mr = r;
				int mc = c;
				for (Integer key : hm.keySet()) {
					r = mr;
					c = mc;

					int R = hm.get(key).r;
					int C = hm.get(key).c;

					int totalcnt = 0;

					while (true) {
						if (r < R) {
							int cnt = 0;
							while (true) {
								r += 1;
								cnt++;
								if (board[r][c] != 0) {
									cnt = 1;
								}
								if (r >= board.length || r >= R) {
									break;
								}
							}
							if (board.length - r <= cnt) {
								totalcnt += 1;
							} else {
								totalcnt += cnt;
							}

						} else if (r > R) {
							int cnt = 0;
							while (true) {
								r -= 1;
								cnt++;
								if (board[r][c] != 0) {
									cnt = 1;
								}
								if (r < 0 || r <= R) {
									break;
								}
							}
							if (r <= cnt) {
								totalcnt += 1;
							} else {
								totalcnt += cnt;
							}
						}

						if (c < C) {
							int cnt = 0;
							while (true) {
								c += 1;
								cnt++;
								if (board[r][c] != 0) {
									cnt = 1;
								}
								if (c >= board.length || c >= C) {
									break;
								}
							}
							if (board.length - c <= cnt) {
								totalcnt += 1;
							} else {
								totalcnt += cnt;
							}
						} else if (c > C) {
							int cnt = 0;
							while (true) {
								c -= 1;
								cnt++;
								if (board[r][c] != 0) {
									cnt = 1;
								}
								if (c < 0 || c <= C) {
									break;
								}
							}
							if (c <= cnt) {
								totalcnt += 1;
							} else {
								totalcnt += cnt;
							}
						}

						if (board[r][c] != 0) {
							break;
						}
					}
					if (totalcnt < min) {
						min = totalcnt;
						RR = r;
						CC = c;
					}
				}

				total += min;
				r = RR;
				c = CC;
			}

		}
		return total;
	}
}
