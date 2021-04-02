package sw_expert._0211;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<= T; tc++) {
			int N, M, K;
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			//마지막에 들어오는 사람의 시간까지 시간 축을 탐색
			//M분이 지날 떄마다 K만큼 빵을 추가하고, 사람이 들어올 땐 빵을 하나 씩 줄여가며
			//빵이 음수가 되면 impossible
			//한 번도 없으면 possible
			
			int[] persons = new int[N];
			for(int i=0; i<N; i++)
				persons[i] = sc.nextInt();
			Arrays.sort(persons);
			
			int idx = 0;//사람
			int bread = 0;//빵의 개수
			boolean isOk = true;
			//i는 시간 화살표, 맨 마지막에 들어오는 사람의 시간까지 탐색
			for(int i=0; i<= persons[N-1]; i++) {
				//빵 나올 시간이 되면 빵 추가
				if(i>0 && i% M == 0)
					bread += K;
				//사람 화살표인 idx가 끝나지 않았으면서, 시간 화살표가 사람 화살표가 가리키는 시간과 맞으면
				while(idx < persons.length && i == persons[idx]) {
					//빵 먹고 다음 사람으로
					bread -- ;
					idx ++;
					//빵이 0개보다 적어졌다면 먹을 것이 없으니 impossible
					if(bread<0) {
						//impossible
						isOk = false;
						break;
					}
				}
			}
			System.out.println("#" + tc + " "+ (isOk?"Possible":"Impossible"));
		}
	}
}
