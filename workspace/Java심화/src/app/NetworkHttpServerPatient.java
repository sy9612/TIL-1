package app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import person.Patient;


public class NetworkHttpServerPatient {
	public static void main(String[] args) {
		Patient patient1 = new Patient("김지홍", 25, "010-1234-1234", "수면부족", "000", false);
		Patient patient2 = new Patient("박민asdsadsadsa정", 21, "010-8888-9999", "게임중독", "001", true);
		
		//병원 Collection
		List<Patient> PatientList = new ArrayList<Patient>();
		PatientList.add(patient1);
		PatientList.add(patient2);
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body><h2>환자 정보</h2><table style='border: 1px solid green;'>");
		
		for(Patient h : PatientList) {
			sb.append("<tr style='border: 1px solid green;'><td>").append(h.getName()).append("</td><td>").append(String.valueOf(h.getPhone())).append("</td></tr>");
		}
		sb.append("</table></body></html>");
		String html = sb.toString();
		
		try (ServerSocket ss = new ServerSocket(8080)){
			System.out.println("[Patient Info Server is ready]");
			
			while(true) {
				try(Socket socket = ss.accept()){
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
					
					bw.write("HTTP/1.1 200 OK \r\n");
					bw.write("Content-Type: text/html;charset=utf-8\r\n");
					bw.write("Content-Length: " + html.length() + "\r\n");
					bw.write("\r\n");
					bw.write(html);
					bw.write("\r\n");
					bw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
