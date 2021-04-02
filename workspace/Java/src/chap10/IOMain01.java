package chap10;

import java.io.File;

public class IOMain01 {
	//String은 모든 형태로 벼환 가능
	public static void main(String[] args) {
		File f = new File(args[0]);
		if(f.exists()) {
			System.out.println("파일이름:"+f.getName());
			System.out.println("파일경로:"+f.getPath());
			System.out.println("파일절대경로:"+f.getAbsolutePath());
			System.out.println("파일길이:"+f.length());
			
			System.out.println("쓰기여부:"+f.canWrite());
			System.out.println("읽기여부:"+f.canRead());
		}
		
		f.mkdir();
		f.isDirectory();
		f.isFile();
	}
}
