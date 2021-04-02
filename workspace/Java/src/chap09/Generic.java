package chap09;

//Casting을 의미함
public class Generic<T> {
	private T i;
	public void setI(T i) {
		this.i = i;
	}
	public T getI() {
		return i;
	}
}
