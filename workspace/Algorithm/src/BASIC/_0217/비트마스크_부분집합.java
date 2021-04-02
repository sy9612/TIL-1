package BASIC._0217;


public class 비트마스크_부분집합 {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		//비트마스크를 이용해 부분집합 출력
		//부분집합은 2의 원소의 개수만틈 제곱한 수의 경우의 수가 존재
		//지금은 원소가 3개니까 8개의 부분집합이 존재
		for(int i=0; i<(1<<arr.length); i++) {
			//세개의 원소에 할당된 각 비트가 0인지 1인지 검사
			//0번째 비트 검사(맨 오른쪽 꺼)
			for(int j=0; j<arr.length; j++) {
				if((i & (1<<j)) != 0) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}
	}
	
}
