package chap10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOMain08 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Hello> list = new ArrayList<>();
		list.add(new Hello(10,false, "홍길동"));
		list.add(new Hello(10,false, "둘리"));
		list.add( new Hello(10,false, "또치"));
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hello.seri"));
		oos.writeObject(list);
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hello.seri"));
		ArrayList<Hello> list2 = (ArrayList<Hello>) ois.readObject();
		for(int i =0; i<list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}
}
