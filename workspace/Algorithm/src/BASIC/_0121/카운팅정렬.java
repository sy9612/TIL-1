package BASIC._0121;

public class 카운팅정렬 {
	public static void main(String[] args) {
		int[] A = {4,1,2,6,3,8,7,9,5};
		int[] B = new int [A.length];
		int[] C = new int [10];
		
		for(int i=0; i<A.length; i++) {
			C[A[i]]++;
		}
		for(int j=1; j<C.length; j++) {
			C[j] = C[j] + C[j-1];
		}
		for(int i = A.length-1; i>=0; i--) {
			B[ C[ A[i] ] ] = A[i];
			C[A[i]] = C[A[i]] - 1;
		}
	}
}
