package chap08;

public class TransMain {
	public static void main(String[] args) {
		//Trans t = new Trans();
		//t.print();
		
		Trans c1= new Car(); // Car의 Print를 실행함
		c1.print();

		Car c = new Car();
		c.print();

		//추상 클래스는 실행 할 수 없지만 상위 클래스로 상속할 수 있음
		
		Ship s = new Ship();
		
		s.print();
		
		toPrint(c);
		toPrint(s);
		
		//Interface 객체 생성 불가
		//ITrans it = new ITrans();
		
		ITrans air = new Airplane();
		
	}
	
	static void toPrint(Trans t) {
		t.print();
	}
}
