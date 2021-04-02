package kakao_2020;

import java.util.ArrayList;

public class _3 {
	public static void main(String[] args) {

		String[] orders = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] course = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		int[] answer = solution(orders, course);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(String[] info, String[] query) {
		int c = 0;
		int[] answer = new int[query.length];
		int[] qr = { 0, 2, 4, 6, 7 };

		String[][] kakao = new String[info.length][];
		ArrayList<String[]> java = new ArrayList<>();

		ArrayList<String[]> cpp = new ArrayList<>();

		ArrayList<String[]> python = new ArrayList<>();

		for (int i = 0; i < info.length; i++) {
			kakao[i] = info[i].split(" ");
			if (kakao[i][0].equals("java")) {
				java.add(kakao[i]);
			} else if (kakao[i][0].equals("cpp")) {
				cpp.add(kakao[i]);
			} else if (kakao[i][0].equals("python")) {
				python.add(kakao[i]);
			}
		}

		for (int i = 0; i < query.length; i++) {
			String[] lan = query[i].split(" ");

			int cnt = 0;
			switch (lan[0]) {
			case "-":
				for (int j = 0; j < info.length; j++) {
					boolean ok = true;
					if (Integer.parseInt(kakao[j][4]) < Integer.parseInt(lan[7])) {
						ok = false;
					} else {
						for (int k = 1; k < qr.length - 1; k++) {
							if (lan[qr[k]].equals("-")) {
								continue;
							}
							if (!kakao[j][k].equals(lan[qr[k]])) {
								ok = false;
								break;
							}
						}
					}

					if (ok)
						cnt++;
				}

				break;
			case "java":
				for (int j = 0; j < java.size(); j++) {
					boolean ok = true;
					if (Integer.parseInt(java.get(j)[4]) < Integer.parseInt(lan[7])) {
						ok = false;
					} else {
						for (int k = 1; k < qr.length - 1; k++) {
							if (lan[qr[k]].equals("-")) {
								continue;
							}
							if (!java.get(j)[k].equals(lan[qr[k]])) {
								ok = false;
								break;
							}
						}
					}
					if (ok)
						cnt++;

				}

				break;
			case "python":
				for (int j = 0; j < python.size(); j++) {
					boolean ok = true;
					if (Integer.parseInt(python.get(j)[4]) < Integer.parseInt(lan[7])) {
						ok = false;
					} else {
						for (int k = 1; k < qr.length - 1; k++) {
							if (lan[qr[k]].equals("-")) {
								continue;
							}
							if (!python.get(j)[k].equals(lan[qr[k]])) {
								ok = false;
								break;
							}
						}
					}
					if (ok)
						cnt++;

				}

				break;
			case "cpp":
				for (int j = 0; j < cpp.size(); j++) {
					boolean ok = true;
					if (Integer.parseInt(cpp.get(j)[4]) < Integer.parseInt(lan[7])) {
						ok = false;
					} else {
						for (int k = 1; k < qr.length - 1; k++) {
							if (lan[qr[k]].equals("-")) {
								continue;
							}
							if (!cpp.get(j)[k].equals(lan[qr[k]])) {
								ok = false;
								break;
							}
						}
					}
					if (ok)
						cnt++;

				}

				break;
			}

			answer[c++] = cnt;

		}
		return answer;
	}
}
