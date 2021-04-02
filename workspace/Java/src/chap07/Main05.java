package chap07;

public class Main05 {
	public static void main(String[] args) {
		
		
		Manager m1 = Manager.getInstance();
		Manager m2 = Manager.getInstance();
		
		//같은 주소를 가리킴
		if(m1 == m2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		//같은 주소에 들어가게 됨
		m1.add();
		m2.add();
		
	}
}
