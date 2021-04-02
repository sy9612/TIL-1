package chap10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOMain07 {
	public static void main(String[] args) {
		ArrayList<Hello> list = new ArrayList<>();
		list.add(new Hello(10, false, "홍길동"));
		list.add(new Hello(10, false, "둘리"));
		list.add(new Hello(10, false, "또치"));

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("hello.seri"));
			oos.writeObject(list);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("파일닫기실패");
			}
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("hello.seri"));
			ArrayList<Hello> list2;
			try {
				list2 = (ArrayList<Hello>) ois.readObject();
				for (int i = 0; i < list2.size(); i++) {
					System.out.println(list2.get(i));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
