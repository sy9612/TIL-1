package chap07;

import chap07.staticTest.Inner;

public class Main07 {
	public static void main(String[] args) {
		staticTest st = new staticTest();
		st.print();
		st.staticPrint();
		
		staticTest.staticPrint();
		
		staticTest st2 = new staticTest();
		
		new staticTest();
		
		Inner inner = new staticTest().getInner();
		
		Inner inner2 = new staticTest.Inner();
	}
}
