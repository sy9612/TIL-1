package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result = "";
		int cnt = 0;
		for (int i = 0; i < input.length(); i+=4) {
			String ip2 = Integer.toBinaryString(Integer.parseInt(input.substring(i, i+4)));
			int ip10 = Integer.parseInt(input.substring(i, i+4),2);
			String ip6 = Integer.toHexString(ip10);
			result += ip6;
			cnt++;
			if(cnt == 4 && i < input.length()-4) {
				cnt =0;
				result += ":";
			}
		}
		
		System.out.println(result);
	}
}
