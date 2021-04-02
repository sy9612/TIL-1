package chap05;

//public class는 1개
public class Father {

	int k = 100;

	public String toString() {
		return "father";
	}
	
	public static void main(String[] args) {
		Father f = new Father();
		System.out.println(f.k);
		System.out.println(f.toString());
		Son s = new Son();
		System.out.println(s.k);
		System.out.println(s.toString());

		Father ff = new Son();
		System.out.println(ff.k);
		System.out.println(ff.toString()                  );
	
		if(ff instanceof Son) {
			Son ss = (Son) ff;
			System.out.println(ss.k);
		}
	}

}

//class 안에 class 가능함
class Son extends Father{
	int k = 200;
	
	public String toString() {
		return "son";	
	} 
}
