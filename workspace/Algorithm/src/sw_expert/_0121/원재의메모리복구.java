package sw_expert._0121;

import java.util.Scanner;

public class 원재의메모리복구 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			//�ԷµǴ� �޸� ��Ʈ ���� ����
			char[] input = sc.next().toCharArray(); //���ڿ��� �ٲ㼭 �Է�
			//�ԷµǴ� �޸� ���°� 0���ε� ������ �� �����Ƿ�, ������ �Է¹޾Ƽ� �ȵ� -> ���ڿ�
			//�ʱ���°� ��� 0�� ��Ʈ���� ����
			char[] sol = new char[input.length]; //ĭ�� ���̴� input�� ����
			//sol�迭�� ��� 0���� �ʱ�ȭ
			for(int i=0; i<sol.length; i++)
				sol[i] = '0';
			int cnt = 0;
			//input�� ù��°ĭ���� ������ĭ���� �˻�
			for(int i=0; i<input.length; i++) {
				//input�� sol�� i��° ĭ�� ���� ��
				//�ٸ���
				if(input[i] != sol[i]) {
					cnt++;
					//sol�� i��° ��ġ���� ����° ��ġ���� ��� input[i]������ ����
					for(int j=i; j<sol.length; j++)
						sol[j] = input[i];
				}
				//������ = �н�
			}
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
}
