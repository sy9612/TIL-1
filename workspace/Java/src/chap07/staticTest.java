package chap07;

public class staticTest {
	int a;
	static int st;

	// instance block: 생성자 전에 호출
	// 모든 생성자에 공통으로 들어 갈 내용은 instance block 안에 삽입
	{

	}

	// static block
	// 처음 한 번만 실행
	static {
		System.out.println("static block");
	}

	public staticTest() {
		System.out.println("점심먹고싶다");
	};

	public staticTest(int a) {
		System.out.println("점심먹고싶다");
	};

	void print() {
		a = 10;
		st = 20;
		staticPrint();
	}

	static void staticPrint() {
		st = 20;
		// a = 10;
		int ff = 10;

		// 사용불가
		// Print();
	}

	// 내부 클래스에 접근 할 수 없음
	// public이라 하더라도 접근 불가
	// static을 만들어야 가능
	public Inner getInner() {
		Inner in = new Inner();
		return in;
	}

	public static class Inner
	{
		staticTest st;
		public Inner() {
			st =  new staticTest();

		}

		public void print() {
			st.print();
		}
	}

}
