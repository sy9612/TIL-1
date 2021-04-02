package sw_expert._0121;
import java.util.Scanner;

public class 가위바위보 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// a�� ������ ���� ��
			if(a==1) {
				// b�� ������ ���� a�� ��
				if(b==2) {
					System.out.println("B");
				}
				// b�� ���� ���� a�� �̱�
				else if(b==3) {
					System.out.println("A");
				}
			}
			// a�� ������ ���� ��
			else if(a==2) {
				if(b==1) {
					System.out.println("A");
				}
				else if(b==3) {
					System.out.println("B");
				}
			}
			// a�� ���� ���� ��
			else if(a==3) {
				if(b==1) {
					System.out.println("B");
				}
				else if(b==2) {
					System.out.println("A");
				}
			}
		}
	}
}
