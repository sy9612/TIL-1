package chap07;

public class Member {
	String name;
	int age;
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member) obj;
			if(this.name == m.name && this.age == m.age)
				return true;
		}
		return false;
	}
	
}
