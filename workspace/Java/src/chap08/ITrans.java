package chap08;
//상수와 구현되지 않은 method로 구성
//객체화 불가능
public interface ITrans {
	//자동으로 public static final이 붙음
	public static final int a = 1; // 항상 public이어야 함 (private는 error)
	
	//public abstract가 함수 앞에 자동으로 붙음
	//구현부 생성 불가
	public abstract void print();
	
}
