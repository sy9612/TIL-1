package chap09;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("seoul");
		list.add("daejeon");
		list.add("gumi");
		list.add("gwangju");
		list.add("seoul");
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		System.out.println("-----------------------------");
		for(String string: list)
			System.out.println(string);
		System.out.println("-----------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
