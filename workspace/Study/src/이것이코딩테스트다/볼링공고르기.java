package 이것이코딩테스트다;

import java.util.Scanner;

/**
 * ���� �ٸ� ���� ���� ���Ը� ���� ���(����)
 * --> ������������ �����ϰ� Ǯ �� ����
 * 
 * �׸����ϰ� Ǫ�¹�
 * --> �� step�� �������� �̹� ����ߴ� ������ ���ִ� ���
 * ���� ���縦 ��������Ƿ� (M�� 10�� ���� �� ����) -> �ϳ��� ����Ʈ ���� �����Ͽ� ���Ժ� ������ ���� ����
 * @author 15com
 *
 */
public class 볼링공고르기{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] K = new int[N];
		int[] weight = new int[M+1];
		
		for (int i = 0; i < K.length; i++) {
			K[i] = sc.nextInt();
			weight[K[i]]++;
		}
		
		int result = 0;
//		���Ը� ��������
		for (int i = 1; i < weight.length; i++) {
//			���� ���Դ� ����� ��
			N -= weight[i]; // ��ü ������ ���� - ���԰� i�� ������ ���� = B�� ���� ������ ������ ����
			result += weight[i] * N; // A�� ������ ������ ������ ���� * B�� ���� ������ ������ ����
		}
		
		System.out.println(result);
	}
}
