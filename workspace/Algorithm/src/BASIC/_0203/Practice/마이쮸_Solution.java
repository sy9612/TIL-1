package BASIC._0203.Practice;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸_Solution {
	static class Person{
		int num;
		int cnt;
	}
	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>();
		int mychuCnt = 20;
		
		int pNum = 1;
		Person p = new Person();
		p.num = 1;
		p.cnt = 1;
		queue.offer(p);
		
		while(mychuCnt>0) {
			//큐의 맨 앞에 있는 사람을 꺼내서 해당 사람이 먹어야 될 마이쮸의 개수만큼 먹은 후
			p = queue.poll();
			mychuCnt -= p.cnt;
			//먹어야 될 마이쮸 개수를 하나 늘려서 큐에 다시 enQueue
			p.cnt += 1;
			queue.offer(p);
			//새로운 사람을 마이쮸 갯수 1개로 큐에 enQueue
			Person newPerson = new Person();
			newPerson.num = ++pNum;
			newPerson.cnt = 1;
			queue.offer(newPerson);
		}
		System.out.println(p.num);
	}

}
