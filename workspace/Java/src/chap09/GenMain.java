package chap09;

import chap09.SetTest.Hello;

public class GenMain {
	static class Hello{
		int a;
		int b;
		Hello(int a, int b){
			this.a = a;
			this.b = b;
		}
		@Override
		@Deprecated //사용불가
		public String toString() {
			// TODO Auto-generated method stub
			return "Hello [a=" + a +", b=" + b +"]";
		}
		@Override
		public boolean equals(Object obj) {
			Hello h = (Hello) obj;
			if(this.a == h.a && this.b == h.b)
				return true;
			return false;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return a^b;
		}
	}
	public static void main(String[] args) {
		//3가지 타입을 모두 입력해야 에러가 나지 않음
		Generic<Hello> g =new Generic();
		g.setI(new Hello(1,1));
//		g.setI(3);
//		g.setI("aaaa");
//		g.setI(3.5);
		
		// ... 을 이용하면 여러개의 인자를 주고받을 수 있음 -> 받을 때 배열 형태로 받게 됨
		
		Hello i = g.getI();
		GenericSub gs = new GenericSub();
	
		
	}
}
