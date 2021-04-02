package chap05;

public class Employee extends Object{
	public String sabun;
	protected String name;
	protected int salary;	
	
	int getSalay(){
		return salary;
	}
	
	public Employee() {
		System.out.println("Employee constructor");
	}
	Employee(String sabun, String name, int salary){
		this.sabun = sabun;
		this.name =name;
		this.salary = salary;
	};	
	
	public String toString() {
		return "Employee [saban= " + sabun + ", name= " + name + ", salary= " + salary +"]";
	}

}
