package app;

import virus.CoronaThread;

public class CoronaTreadTest {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
//			CoronaRunnable cr = new CoronaRunnable(i);
//			Thread t = new Thread(cr);
//			t.start();
			
			CoronaThread ct = new CoronaThread(i);
			ct.start();
		}
	}
}
