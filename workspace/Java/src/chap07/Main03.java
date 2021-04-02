package chap07;

public class Main03 {

	public static void main(String[] args) {
		String s = "s";
		String s1 = "s";
		String s2 = "a";
		String s3 = "f";
		String s4 = "y";
		
		double start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			s += s1;
			s += s2;
			s += s3;
			s+= s4;
		}
		double end = System.currentTimeMillis();
		System.out.println("time 1 : " + (end-start));
	
	
		StringBuilder sb = new StringBuilder();
	
		 start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			sb.append("s");
			sb.append("s");
			sb.append("a");
			sb.append("f");
			sb.append("y");
		}
		 end = System.currentTimeMillis();
		 

		System.out.println("time 2 : " + (end-start));
	
		int a = 10;
		String str = "hello";
		char ch = 'a';
		System.out.println(a + ch + str);
		
		String str11 = "Hello";
	}
	
	int add(int a, int b) {
		return a+b;
	}
}
