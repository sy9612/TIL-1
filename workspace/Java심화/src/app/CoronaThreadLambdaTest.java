package app;

public class CoronaThreadLambdaTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous Thread 생성");
			}
		}).start();
		
		new Thread( () -> System.out.println("Llambda Thread 생성")).start();
	}
}
