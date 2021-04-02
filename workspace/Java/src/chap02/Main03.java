package chap02;

public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] jumsu = new int[3];
		jumsu[0] = 99;
		jumsu[1] = 90;
		jumsu[2] = 80;

		int[] tar = new int[3];

		// 얕은 복사
		tar = jumsu; // 두 개의 변수가 하나의 값을 가르킬 수 있음

		System.out.println(tar[0]);

		jumsu[0] = 11;

		System.out.println(tar[0]);

		deepCp(jumsu);

		// 2차원 배열
		int[][] aarr = new int[][] { { 1, 3, 5 }, { 2, 4, 8 } };
		int[][] tarr = new int[2][3];

		for (int i = 0; i < tarr.length; i++) {
			System.arraycopy(aarr[i], 0, tarr[i], 0, aarr.length);
		}
	}

	private static void deepCp(int[] jumsu) {
		int[] tar = new int[jumsu.length];

		// 깊은 복사
		for (int i = 0; i < tar.length; i++) {
			tar[i] = jumsu[i];
		}
		jumsu[0] = 99;

		// tar의 값은 그대로
		System.out.println(tar[0]);

		System.arraycopy(jumsu, 0, tar, 0, jumsu.length);
	}
}
