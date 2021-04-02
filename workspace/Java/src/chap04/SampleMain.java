package chap04;

public class SampleMain {

	public static void main(String[] args) {
		Sample s = new Sample();
		s.no = 100;
		s.name = "고길동";
		s.catego = "좋은사람";
		
		s.print();
		
		Sample s2 = new Sample();
		
		s2.no = 200;
		s2.name = "둘리";
		s2.catego = "나쁜놈";
		
		s2.print();
		
	}

}
