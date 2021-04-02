package chap05._0206;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//불가능
		//Animal a = new Animal();
		Bird b = new Bird();
		Dog d = new Dog();
		Human h = new Human();
		Superman s = new Superman();
		
		toMove((Animal)b);
		toMove(d);
		toMove(h);
		toMove(s);
		
		toMove(s);
		toMove(s);
		
		toFly(s);
		toFly(b);
	}
	static void toFly(IFly s) {
		s.fly();
	}
	static void toMove(Animal b) {
/*		if(b instanceof Superman) {
			Superman s = (Superman)b;
			s.fly();
		}*/
			b.move();
		
	}
//	static void toMove(Dog b) {
//		b.move();
//	}
//	static void toMove(Human b) {
//		b.move();
//	}
//	static void toMove(Superman b) {
//		b.move();
//	}

}
