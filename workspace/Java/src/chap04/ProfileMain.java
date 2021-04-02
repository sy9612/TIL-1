package chap04;

public class ProfileMain {

	public static void main(String[] args) {
		Profile p = new Profile();
		p.name = "홍길동";
		p.age = 21;
		p.gender = false;
		p.no = 1000;
		
		System.out.println(p.toString());
		
		Profile p2 = new Profile();
		p2.name = "홍길순";
		p2.age = 22;
		p2.gender = false;
		p2.no = 2000;
		
		System.out.println(p2.toString());
	}

}
