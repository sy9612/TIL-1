package chap07;

public class Main01 {

	public static void main(String[] args) {
		Member m1 = new Member("홍길동", 21);
		Member m2 = new Member("홍길동", 21);

		if (m1 == m2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		if (m1.equals(m2)) {
			System.out.println("같다");
		} else
			System.out.println("다르다");
	}
}
