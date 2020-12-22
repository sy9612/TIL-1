
import java.util.Arrays;
import java.util.Scanner;
/**
 * N���� ������ŭ ���ڰ� �־����� ��, ���� �� ���� �ּ� ���� ã��
 * sort �� �տ������� ���ڸ� ���ؼ� target ����
 * @author 15com
 *
 */
public class 만들수없는금액 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int target = 1;
		for (int i = 0; i < arr.length; i++) {
			if( target < arr[i]) {
				break;
			}
			target += arr[i];
		}
		 
		System.out.println(target);
	}

	
}
 
