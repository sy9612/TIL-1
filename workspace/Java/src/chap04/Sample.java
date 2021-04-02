package chap04;

public class Sample {

	int no = 100;
	//int no = 07 -> 앞이 0으로 시작하면 8진수로 인식
	//int no = 0xF -> 앞이 0x로 시작하면 16진수로 인식
	String name;
	String catego;
	
	void print() {

		System.out.println(no + " " + name + " "+ catego);
	}
}
