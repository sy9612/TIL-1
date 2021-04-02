package chap07;

public class Main06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		staticTest st = new staticTest();
		st.a = 10;
		
		
		//static 변수
		staticTest.st = 10;
		staticTest st2 = new staticTest();
		st2.a=20;
		
		//서로 영향을 줄 수 없음
		st.a++;
		System.out.println(st2.a);
			
		staticTest.st = 10;
		
		System.out.println(st.st);
		
		st.st++;
		
		System.out.println(st2.st);
	}

}
