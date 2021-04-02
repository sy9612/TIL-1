package chap05._0206;

public class Bird extends Animal implements IFly{
	public void move() {
		System.out.println("새가 움직입니다");
	}
	public void fly() {
		System.out.println("새가 날아다닙니다");
	}
}
