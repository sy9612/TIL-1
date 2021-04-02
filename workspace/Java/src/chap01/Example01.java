package chap01;

public class Example01 {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			int dit = (int) (Math.random() * 100) % 46 + 1;
			System.out.print(dit + " ");
		}
	}

}
