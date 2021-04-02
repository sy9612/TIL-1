package chap10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Hello implements Serializable{
	int a = 10;
	boolean b =false;
	String str = "Hello";
	
	public Hello(int a, boolean b, String str) {
		this.a = a;
		this.b = b;
		this.str = str;
	}

	@Override
	public String toString() {
		return "Hello [a=" + a + ", b=" + b + ", str=" + str + "]";
	}
	
	
}
public class IOMain06 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("data.serial");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(new Hello(10,true,"홍길동"));
		System.out.println("쓰기완료");
		os.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.serial"));
		Hello obj = (Hello) ois.readObject();
		System.out.println(obj.toString());
	}
}
