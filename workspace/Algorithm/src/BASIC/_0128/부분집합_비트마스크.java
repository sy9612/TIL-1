package BASIC._0128;

public class 부분집합_비트마스크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"A", "B", "C", "D"};
		int[] nums = {1,2,3,-4};
		// 원소의 개수에 따라
		// 1 << arr.length = 2^n
		// 따라서 현재 코드에서 2^3 = 8
		for(int i=0; i< (1 << arr.length); i++) {
			// i에 대해서, A가 선택된지 여부: 1<< 0 미룬 것과 i를 마스킹해서 0인지 아닌지 검사
			//			B가 선택된지 여부: 1<< 1 미룬 것과 i를 마스킹해서 0인지 아닌지 검사
			//			C가 선택된지 여부: 1<< 2 미룬 것과 i를 마스킹해서 0인지 아닌지 검사
			int sum = 0;
			for(int j=0; j<arr.length; j++) {
				if( (i & (1 << j)) != 0 ) {
					//j번째 원소 선택
					sum += nums[j];
				}
				
			}
			if(sum == 0) {
				for(int j=0; j<arr.length; j++) {
					if((i&(1<<j))!=0)
						System.out.print(arr[j]);
				}
			}			
			System.out.print(" ");
		}
		System.out.println();
	}
}
