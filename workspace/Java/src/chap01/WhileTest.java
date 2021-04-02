package chap01;

public class WhileTest {
	public static void main(String[] args) {
		int x = 1;
		while (x++ < 9) {
			int j = 0;
			
			while (j++ < 9) {
				if(j == 5) continue;
				System.out.println(x + " * " + j + " = " + x * j);
			}
			if(x == 8) break;    
		}                  
	}
}
