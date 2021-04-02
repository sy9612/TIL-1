package chap10;

import java.io.FileReader;
import java.io.IOException;

public class IOMain03 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("hello.txt");
		
		int ch = '\u0000';
		//read의 반환형은 int형
		while((ch = fr.read()) != -1) {
			System.out.print((char)ch);
		}
		System.out.println();
	}
}
