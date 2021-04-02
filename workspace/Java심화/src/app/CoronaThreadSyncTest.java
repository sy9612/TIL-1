package app;

import virus.Cell;
import virus.CoronaThreadSync;
import virus.RedBloodThread;

public class CoronaThreadSyncTest {
	public static void main(String[] args) {
		Cell cell =new Cell();
		
		for(int i=0; i<10; i++) {
			CoronaThreadSync t = new CoronaThreadSync(cell);
			t.start();
		}
		
		for(int i=0; i<10; i++) {
			RedBloodThread t = new RedBloodThread(cell);
			t.start();
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Cell's power is " + cell.power);
	}
	
}
