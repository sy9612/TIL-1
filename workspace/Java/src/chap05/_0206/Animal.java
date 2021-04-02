package chap05._0206;

//추상 클래스가 되어야 함
public abstract class Animal implements IEat{
	public abstract void move();
	
	@Override
	public void eat() {
		System.out.println("냠냠");
	}
	
	/*{
		//정의 할 수  없음
		System.out.println("......");
	}*/
}
