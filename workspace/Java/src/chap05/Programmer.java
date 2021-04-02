package chap05;

public class Programmer extends Employee{
	// 1 im 2 ad 3 ad+ 4 pro
	public int sogum;
	public Programmer() {
		super("200","100",2000);
		/* private -> 상속은 되지만 접근할 수 없음
		 * this.salary = 100;*/
		System.out.println("Programmer constructor");
	}
	
	public Programmer(String sabun, String name, int salary, int sogum) {
		super("200","100",20000);

		this.sabun = sabun;
		this.name = name;
		this.salary = salary;
		this.sogum = sogum;
		
		//super: Employee
		//super.sogum이 존재하지 않음
	}
	
	//재정의
	public int getSalary() {
		return salary*sogum;
	}

	@Override
	public String toString() {
		return "Programmer [sogum=" + sogum + ", sabun=" + sabun + ", name=" + name + ", salary=" + salary
				+ ", getSalary()=" + getSalary()+ "]";
	}
}
