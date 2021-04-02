package chap05._0206;

public class Human extends Animal implements ILove{
	public void move() {
		
		System.out.println("사람이 걸어요");
	}
	@Override
	public void love() {
		System.out.println("사랑해~~~~~~~~~~~~");
	}
}
