package sw_expert;

import java.util.*;
import java.io.*;

public class 햄버거다이어트 { 
	static int limit;
	static int max;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int l = Integer.parseInt(br.readLine());

		for (int p = 0; p < l; p++) {
			StringTokenizer tc = new StringTokenizer(br.readLine(), " ");
			int number = Integer.parseInt(tc.nextToken());
			limit = Integer.parseInt(tc.nextToken());

			int[] pList = new int[number];
			int[] cList = new int[number];

			for (int i = 0; i < number; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int point = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());

				pList[i] = point;
				cList[i] = calorie;
			}

			max = 0;
			DFS(pList, cList, 0, pList[0], cList[0]);
			sb.append("#").append(p + 1).append(" ").append(max);

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void DFS(int[] pList, int[] cList, int idx, int point, int calorie) {
		if (calorie > limit)
			return;
		if (idx == pList.length) {
			max = Math.max(point, max);
			return;
		}

		DFS(pList, cList, idx + 1, point, calorie);
		DFS(pList, cList, idx + 1, point + pList[idx], calorie + cList[idx]);
	}
}
