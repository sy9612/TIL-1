package chap02;

import java.util.Arrays;

public class Main01 {
	// Array
	// 정의: 같은 데이터의 순서적 나열
	// 특성: 선언과 동시에 크기가 결정되어지고 크기가 변경될 수 없다.
	// 배열을 선언하면 기본값으로 초기화가 일어난다.
	// 정수: 0, 실수: 0.0, 문자: /u0000, 참조(reference): null
	
	public static void Main01 (String[] args) {
		int kuk=99, math=90, eng=80;
		int[] jumsu = new int[3];
		jumsu[0] = 99;
		jumsu[1] = 90;
		jumsu[2] = 80;
/*
		//ArrayList: 현재 상태의 size를 return해야 하므로 기능적으로 구현
		ArrayList a = new ArrayList<>();
		a.size(); //함수
*/		
		//length = 변수 -> final 변수
		//배열은 길이가 정해져있으므로 변수로 선언
		for(int i=0; i<jumsu.length; i++) {
			System.out.println(jumsu[i]);
		}
		
		System.out.println(Arrays.toString(jumsu));
		
		change(kuk, jumsu);
		System.out.println("Main = " + kuk);
		System.out.println("Main jumsu[0] = "+jumsu[0]); //값이 바뀌어져 있음
		//원래의 값에도 바뀌어져 있음
		
		
		Member[] mems = new Member[2];
		
		mems[0] = new Member();
		mems[1] = new Member();
		System.out.println(mems[0].name);
		System.out.println(mems[1].name);
	}
	
	//call by reference
	private static void change(int kuk, int[] aj) {
		kuk++;
		System.out.println("chage kuk = "+kuk);
		aj[0]++;
		System.out.println("chage aj[0] = " + aj[0]);
	}
}

class Member{
	public String name = "홍길동";
	
}
