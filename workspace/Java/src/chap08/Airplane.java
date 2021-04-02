package chap08;
//Interface를 받기 위해 implements 사용
//업캐스팅 가능

//Interface와 Trans 동시 사용 가능 -> 멀티 상속과 같이 사용 가능
//Interface는 여러개를 받을 수 있음
public class Airplane extends Trans implements ITrans, ITrans2{
	public static final int a =1;
	//추상클래스가 되지 않으려면 body를 생성해야함
	
	//modifier를 할 때 자기자신과 같거나 큰 것을 할당해야 가능
	public void print() {};
	
}
