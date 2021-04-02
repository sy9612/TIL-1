package sw_expert;

import java.util.*;

public class 비밀번호_1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			String str = sc.next();
			
			Vector<Integer> vector = new Vector<Integer>();
			
			for(int i=0; i<str.length(); i++) {
				vector.addElement( str.charAt(i) - '0');
			}
			
			for(int i=0; i<vector.size()-1; i++) {
				if(vector.elementAt(i) == vector.elementAt(i+1)) {
					vector.remove(i);
					vector.remove(i);
					i-=2;
					if(i<0)
						i =-1;
				}
			}
			
			for(int i=0; i<vector.size(); i++)
				System.out.print(vector.elementAt(i));
			System.out.println();
		}
	}

}
