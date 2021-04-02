package BASIC._0121.Practice;

public class Gravity_Solution {
	public static void main(String[] args) {
		int[] input = {7,4,2,0,0,6,0,7,0};
		
		int max = 0; //���� ���� ������ ����� ����
		//��� ����⿡ ���ؼ� ������ ���
		for(int i=0; i<input.length; i++) {
			//�� ���������� �ִ� ĭ�� ���� Ȯ��(�ִ� ����)
			int cnt = input.length - (i+1); //�� ��ġ���� �� ���� �� ���� �� ������������ ĭ�� ������ ����
			//cnt���� �� �����ʿ� �����ϴ� ������ ũ�ų� ���� ������� ������ŭ ����
			//�� �� ĭ �����ʺ��� �� �������� �˻��ϸ�, ������ ũ�ų� ���� ���� �ִ� �� Ȯ��
			for(int j = i+1; j<input.length; j++) {
				if(input[i] <= input[j])
					cnt--;
			}
			if(max < cnt)
				max = cnt;
			
		}
		
		System.out.println(max);
	}
}
