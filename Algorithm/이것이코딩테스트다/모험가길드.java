
import java.util.Arrays;
import java.util.Scanner;

/**
 * ������ <= ���谡 ��
 * ������������ ���� �ͺ��� ���ǿ� �����ϴ� �� ����
 * @author 15com
 *
 */
public class 모험가길드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		int pp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			pp++;
			if(pp >= arr[i]) {
				pp = 0;
				result += 1;
			}
		}
		
		System.out.println(result);
		
	}
}
