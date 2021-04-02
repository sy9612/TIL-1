package chap10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOMain04 {
	public static void main(String[] args) throws IOException {
//		FileOutputStream fos = new FileOutputStream("hello.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		//osw.write("Hello My First Process Stream !!"); //속도가 느림
//		BufferedWriter bw = new BufferedWriter(osw);
//		bw.write("Hello My First Process Stream !!");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("hello.txt")));
		bw.write("Hello My First Process Stream !!");
		bw.flush();
		bw.close();

		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hello.txt")));
		
		String str = new String();
		
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
				
	}
}
