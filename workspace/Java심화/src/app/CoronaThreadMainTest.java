package app;

import virus.CoronaRunnable;

public class CoronaThreadMainTest {
	public static void main(String[] args) {
		CoronaRunnable cr = new CoronaRunnable(2020);
		Thread t = new Thread(cr);
		t.start();
		
		try {
			t.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread end");
	}
}
