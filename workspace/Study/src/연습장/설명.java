package 연습장;

public class 설명 {
	// 사람 객체(class) 선언
	static class Person{
		// 사람이라는 객체 안에는 이름과 나이가 존재
		// private로 보호 (c++에서는 다를 수 있음)
		private String name;
		private int age;
		

		// 생성자
		
		// 기본 생성자 - 그냥 Person 객체만 만듦
		Person(){}
		
		// 객체를 생성하면서 name 주입
		Person(String name){
			// this는 현재 가리키고 있는 객체 위치
			this.name = name;
		}
		
		// 객체를 생성하면서 age 주입
		Person(String name, int age){
			this.age = age;
			this.name = name;
		}

		
		// 캡슐화 - get/set (정보보호)
		// get 함수는 현재 객체안에 담긴 변수들을 return한다.
		int getAge() {
			return this.age;
		}
		String getName() {
			return this.name;
		}	
		
		// set 함수는 현재 객체안에 담긴 변수들에 값을 넣어준다.
		void setAge(int age) {
			this.age = age;
		}
		void setName(String name) {
			this.name = name;
		}
		
		
		// 각 변수 출력
		// 이와 같이 class 객체 안에 함수를 자유롭게 선언 가능
		void printName() {
			System.out.println(this.name);
		}
		void printAge() {
			System.out.println(this.age);
		}
	}
	
	public static void main(String[] args) {
		
		// 일반 객체 생성 - 생성자를 만들어주지 않으면 사용 가능한 default
		// 생성자를 만들었다면, default 생성자가 없으므로 사용하기 위해서는 위와 같이 선언이 필요
		Person p1 = new Person(); //p1은 이름, 나이가 모두 주입되어 있지 않다.
		
		
		// p1 객체의 함수를 사용
		// c++의 경우 자동 초기화가 되지 않으므로 error가 발생하거나 null값 출력
		// java는 자동 초기화가 되기 떄문에 각각 0과 null을 출력
		p1.printAge();
		p1.printName();
		
		// 이름만 넣는 생성자
		Person p2 = new Person("홍길동"); //p2는 이름은 주입되어 있지만 나이는 없다.
		
		// java에서는 age는 0, 이름은 홍길동 출력
		p2.printAge();
		p2.printName();
		
		// 이름, 나이 모두 주입하는 생성자
		Person p3 = new Person("김지홍", 11); //p3는 이름, 나이 모두 존재
		
		// age는 11, 이름은 김지홍 출력
		p3.printAge();
		p3.printName();
		
		//----------------------
		
		// p1에 값 주입
		p1.setAge(50);
		p1.setName("신영준");
		
		// 각각 신영준, 50을 출력
		// getAge는 나이를 return 한다. 이후 출력
		System.out.println(p1.getAge());
		// 그냥 이름 출력
		p1.printName();
		
		
	}
}
