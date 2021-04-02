package chap07;

public class Main04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;

		// object 상속
		// 자바 1.5
		Integer ia = new Integer(10);
		Integer ib = new Integer(10);
		String string = ia.toString();
		a = ia.intValue();

		// Integer의 경우 대표 타입이기 때문에 객체로 보지 않고 형변환을 해버림
		Integer a1 = 10;
		Integer a2 = 10;

		if (a1 == a2)
			System.out.println("같다");
		else
			System.out.println("다르다");

		// Integer를 제외한 다른 타입들은 객체로 인식함
		Double dd1 = 3.0;
		Double dd2 = 3.0;
		// 다르다
		if (dd1 == dd2) {
			System.out.println("같다");
		} else
			System.out.println("다르다");

		// 자바 5.0
		// 형태 자동 변경
		ia = a;
		a = ia;

		if (ia == ib) {
			System.out.println("같다");

		} else
			System.out.println("다르다");

		if (ia == a) {
			System.out.println("같다");

		} else
			System.out.println("다르다");

		double d = 3.0;
		Double dd = new Double(3.0);

		// 자동 형변환이 일어나게 됨
		// 원래는 다름
		if (d == dd) {
			System.out.println("같다");
		} else
			System.out.println("다르다");

	}

}
