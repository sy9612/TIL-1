package sw_expert._0121;

//Scanner �Է�
import java.util.Scanner;

public class 몫과나머지구하기 {
	public static void main(String[] args) {
		// ���
//		System.out.println("Hello World Welcome to hell");

		// �Է� - �� ���� ����
		// int a = System.in.read(); //���� ����Ʈ�� ����

		// ������ ���·� �Է�
		Scanner sc = new Scanner(System.in); // ��ĳ�ʿ� �Է�

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt(); // SYstem.in���� �ԷµǴ� �����͸� 4����Ʈ �о ������ ����
			// ��ٸ��鼭 ������� �Է°��� ����

			int b = sc.nextInt();

			int quotient = a / b;
			int remainder = a % b;

			// System.out.print(quotient + " ");
			// System.out.println(remainder);

			System.out.println("#" + tc + " " + quotient + " " + remainder);
		}

	}
}
