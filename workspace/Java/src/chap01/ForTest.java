package chap01;

public class ForTest {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			if (i==4) break;
			if(i==7) continue;
			for (int j = 1; j <= 9; j++) {
				if(j==4) continue;
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
	}
}
