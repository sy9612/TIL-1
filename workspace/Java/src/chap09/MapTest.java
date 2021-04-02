package chap09;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> m = new HashMap<>();
		m.put("11", "둘리");
		m.put("22", "고길동");
		m.put("33", "또치");
		m.put("44", "도우너");
		
		System.out.println(m.get("33"));
		System.out.println("-----------------------------");
		//1.4
		Iterator iter = m.keySet().iterator();
		while(iter.hasNext())
			System.out.println(m.get(iter.next()));
		//5.0
		System.out.println("-----------------------------");
		for(String key: m.keySet())
			System.out.println(key + ":" + m.get(key));
	}
}
