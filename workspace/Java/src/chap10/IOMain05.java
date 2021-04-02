package chap10;
import java.io.*;
public class IOMain05 {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		
		dos.writeInt(3);
		dos.writeDouble(4.5);
		dos.writeUTF("Hello");
		dos.flush();
		dos.close();
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
		
		//Serializable(); // 마크 인터페이스
		//미구현 메소드가 존재하지 않음
		
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		dis.close();
	}
}
