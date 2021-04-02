package BASIC._0203.Practice;

import java.util.LinkedList;
import java.util.Queue;

class node{
	int number;
	int cnt;
}

public class 마이쮸 {
	static int size = 100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int chuu = size;
		Queue<node> person = new LinkedList<node>();
		node p = new node();
		p.number = 1;
		p.cnt = 1;
		
		person.add(p);
		int start = 1;
		
		while(true) {
			node t = person.poll();
			chuu -= t.cnt;
			if(chuu <= 0)
			{
				System.out.println(t.number);
				break;
			}
			t.cnt++;
			person.add(t);
			
			node n = new node();
			
			start++;
			n.number = start;
			n.cnt = 1;
			
			person.add(n);
			
		}
	}

}
