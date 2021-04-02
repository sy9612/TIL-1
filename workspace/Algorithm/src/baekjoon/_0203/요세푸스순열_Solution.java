package baekjoon._0203;
import java.util.Scanner;

public class 요세푸스순열_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i=1; i<= N; i++)
			arr[i-1] = i;
		
		
		int outputCnt = 0;
		int cnt = 0;
		int idx = 0;
		while(outputCnt < arr.length) {
			if(arr[idx % arr.length] != -1)
				cnt++;
			if(cnt==3) {
				System.out.println(arr[idx%arr.length]);
				cnt = 0;
				arr[idx%arr.length] = -1;
				outputCnt++;
			}
			idx++;
		}
	}

}
