package BASIC._0128;

public class 재귀함수 {
	static int[] arr = {2,4,6,8};
	public static void main(String[] args) {
		/* 0. 간단한 재귀함수 예제를 통해서 함수호출 스택에 대해 이해
		 * 1. 재귀함수의 몸통에 자신을 호출하는 재귀가 두개로 분기되는 경우에서 함수호출 스택을 그려보고, 논리적 레이어에서의 상태공간 트리를 그려 이해하기
		 * 2. 호출하는 재귀가 N개인 경우 연습 확장
		 * 3. 호출하는 재귀가 N개이면서, 이미 다른 경로에서 검사된 요소는 패스*/
		int n = 5;
		
		//반복문은 조건을 보고 맞으면 몸통 수행하고 다시 조건 보는 것을 반복
		//일반적인 반복문은 조건식에서 사용되는 변수를 몸통에서 변화시켜줌
		//while(n<10) { 
		//	System.out.println("?");
		//	n++;
		//}
		
		recur(0,0);
	}
	
	//재귀함수
	//몸통 안에서 자기 자신을 호출하므로 종료되는 조건이 없다면(자기자신을 호출하는 조건이 없다면, 변하지 않는다면) 영원히 반복되거나 아예 수행되지 않거나
	static void recur(int idx, int sum) {
		if(idx == arr.length) {
			System.out.println(sum);
			return;
		}
		
		recur(idx+1,sum + arr[idx]);
	}

}

