

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * �Ķ��Ʈ�� ��ġ: ����ȭ ������ ���� ����(yes or no)�� �ٲپ� �ذ��ϴ� ���
 * ����Ž���� �迭���� ������� �ʾƵ� �ȴ�. ������ �������� �� ���
 * @author jihong.kim
 *
 */

public class 떡볶이떡만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int max = 0;
		// ����Ž��
		
		int left = 0;
		int right = arr[N-1];
		
		while(left <= right) {
			int mid = (left+right)/2;
			int now = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] > mid) {
					now += arr[i]-mid;
				}
			}
			
			if(now < M) {
				right = mid -1;
			}
			else {
				max = mid;
				left = mid+1;
			}
		}
		
		System.out.println(max);
	}
}
