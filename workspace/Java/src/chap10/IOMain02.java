package chap10;
import java.io.*;
public class IOMain02 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(new File("hello.txt"));
		fw.write("Hello My First IO");
		fw.flush();
		fw.close();
		
		System.out.println("write success");
	}
}
