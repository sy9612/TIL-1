package chap07;

public class Manager {
	int[] arr;
	static Manager m = new Manager();
	//private로 선언하면 객체생성을 할 수 없음

	//같은 객체를 반환
	static Manager getInstance() {
		return m;
	}
	
	private Manager(){
		arr = new int[10];
	}
	
	public void add() {};
}
