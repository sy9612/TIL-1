package Practice.JavaFile;
public class 별찍기 {

	public static void main(String[] args) {
		//삼각형
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<5; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		//역삼각형
		for(int i=5; i>=0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			
			System.out.println();
		}
		
		//역삼각형
		for(int i=0; i<6; i++) {
			for(int j=0; j<i; j++)
				System.out.print(" ");
			for(int j=i+1; j<6; j++)
				System.out.print("*");
			System.out.println();
		}
		
		//삼각형
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
