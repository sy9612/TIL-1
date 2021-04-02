package chap04;

public class OverloadTest {

	int add (int a, int b){
		return a+b;
	}
	float add (float a, float b){
		return a+b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadTest o = new OverloadTest();
		System.out.println(o.add(3, 2));
		
		//실수의 기본 자료형 = double
		System.out.println(o.add(3.1f, 2.2f));
		
		//public final static PrintStream out = null;
		// pubilc같은 클래스 안에 있는 것만 가능
		//나 를 상속 받은 것만 가능
		//누구나 접근 가능
	}

}
