package BASIC._0217;
import java.util.*;
public class 암호비트패턴 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String [10];
		
		arr[0] = "001101";
		arr[1] = "010011";
		arr[2] = "111011";
		arr[3] = "110001";
		arr[4] = "100011";
		arr[5] = "110111";
		arr[6] = "001011";
		arr[7] = "111101";
		arr[8] = "011001";
		arr[9] = "101111";
		
		String num = sc.next();
		StringBuilder sd = new StringBuilder();
		
		for(int i=0; i<num.length(); i++) {
			switch(num.charAt(i)) {
			case 'A':
				sd.append(1010);
				break;
			case 'B':
				sd.append("1011");
				break;
			case 'C':
				sd.append("1100");
				break;
			case 'D':
				sd.append("1101");
				break;
			case 'E':
				sd.append("1110");
				break;
			case 'F':
				sd.append("1111");
				break;
			default:
				if(num.charAt(i)-'0' <2)
					sd.append("000");
				else if(num.charAt(i)-'0' <4)
					sd.append("00");
				else if(num.charAt(i)-'0' <8)
					sd.append("0");
				sd.append(Integer.toBinaryString(num.charAt(i)-'0'));
				
			}
		}
		
		for(int i=0; i<sd.length()-5; i++) {
			for(int j=0; j<10; j++) {
				if(sd.substring(i, i+6).equals(arr[j])) {
					System.out.println(j);
					i += 5;
					break;
				}
			}
		}

	}

}
