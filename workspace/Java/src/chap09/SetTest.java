package chap09;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	static class Hello{
		int a;
		int b;
		Hello(int a, int b){
			this.a = a;
			this.b = b;
		}
		@Override
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
		//generic: <> -> 특정 형태만 사용 가능
		Collection<String> s = new HashSet();
		s.add("seoul");
		s.add("daejeon");
		s.add("gumi");
		s.add("gwangju");
		//중복은 허용하지 않음
		s.add("seoul");
		
//		s.add(new Hello(1,1));
//		s.add(new Hello(1,1));

		//java 1.4 version
		Iterator iter = s.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("--------------------------");
		//java 5.0
		for(Object object : s) {
			System.out.println(object.toString());
		}
	}

}
