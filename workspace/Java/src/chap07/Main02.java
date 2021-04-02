package chap07;

public class Main02 {
	public static void main(String[] args) {
		String s = new String("ssafy");
		String s1 = "ssafy";
		String s2 = "ssafy";
		String s3 = "ssafy";
		
		s2 = s2 + s3;
		
		
		System.out.println(s3.toString());
		
		//s1, s2, s3의 주소가 같다
		if(s1 == s3)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		if(s1 == s2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		
		if(s.equals(s1))
			System.out.println("같다");
		else
			System.out.println("다르다");

		if(s == s1)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
	}
}
