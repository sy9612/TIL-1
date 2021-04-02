package chap10;

// checked Exception
class MyException extends Exception{
	
	public MyException() {
		
	}
	public MyException(String msg) {
		super(msg);
	}
	public void solve() {
		System.out.println("잘 좀 해결해봐....");
	}
}
//컴파일시에는 에러X 런타임시 에러
class MyRuntimeException extends RuntimeException{
	public void alert() {
		System.out.println("MyRuntimeException 발생");
	}
}
class MyArithmeticException extends ArithmeticException{
	
}
public class ExceptionTest1 {
	public static void main(String[] args) {
		int a = 0, b=0;
		try {
			test(a,b);
		}
		catch (MyException e) {
			e.printStackTrace();
			e.solve();
		}
		catch(MyRuntimeException e) {
			e.alert();
		}
		//상속으로 인해 받을 수 있음
		catch (ArithmeticException e) {
			e.printStackTrace();
		}
		//모든 exception을 받으므로
		//가장 아래에 배치해야 함
		catch (Exception e) {
			
		}
		System.out.println("Programming end");
	}

	private static void test(int a, int b) throws MyException {
		if(a == 1) {
			throw new MyException("잘좀해...");
		}
		if(b == 1) {
			//unchecked exception
			//throws MyRuntimeException이 없어도 가능함
			throw new MyRuntimeException();
		}
		if(b==0) {
			throw new MyArithmeticException();
		}
		int c = a/b;
	}
}
