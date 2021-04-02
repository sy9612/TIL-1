package coupang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class _2 {
	public static void main(String[] args) throws ParseException {
		int n = 3;
		String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };

		int[] kos = new int[n];
		String[] ckos = new String[n];
		String[][] kos_time = new String[n][2];

 		for (int i = 0; i < kos_time.length; i++) {
 			kos_time[i][0] = i + "";
		}
 		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

 		for (int i = 0; i < ckos.length; i++) {
 			String[] cus = customers[i].split(" ");
 			String[] day = cus[0].split("/");
 			String[] time = cus[1].split(":");
 			
 			int mit = Integer.parseInt(time[1]) + Integer.parseInt(cus[2]); // 계산시작
			int si = Integer.parseInt(time[0]);
			int di = Integer.parseInt(day[1]);
			int dm = Integer.parseInt(day[0]);

			if (mit >= 60) {
				mit -= 60;
				si++;
			}
			if (si >= 24) {
				si -= 24;
				di++;
			}
			if (di > month[dm]) {
				di = 1;
				dm++;
			}

			ckos[i] = dm + "/" + di + " " + si + ":" + mit + ":" + time[2];
		}
		
		for (int i = n; i < customers.length; i++) {

			// 0 도착 날짜, 1 도착시간, 2 소요시간
			String[] cus = customers[i].split(" ");
 			String[] day = cus[0].split("/");
 			String[] time = cus[1].split(":");
 			
 			int mit = Integer.parseInt(time[1]);// + Integer.parseInt(cus[2]); // 계산시작
			int si = Integer.parseInt(time[0]);
			int di = Integer.parseInt(day[1]);
			int dm = Integer.parseInt(day[0]);

//			if (mit >= 60) {
//				mit -= 60;
//				si++;
//			}
//			if (si >= 24) {
//				si -= 24;
//				di++;
//			}
//			if (di > month[dm]) {
//				di = 1;
//				dm++;
//			}
//			int k = 0;
//			String cus_time = dm + "/" + di + " " + si + ":" + mit + ":" + time[2];
			
			
			//운영되지 않는 게 있을 때
			boolean check = false;
			int max = 0;
			int maxk = 0;
			for (int j = 0; j < ckos.length; j++) {

				// 현재 선택한 키오스크
				// 0 도착 날짜, 1 도착시간
				String[] now_cus = ckos[j].split(" ");
				// 0 월, 1 일
				String[] now_day = now_cus[0].split("/");

				if (Integer.parseInt(now_day[0]) <= Integer.parseInt(day[0])) {
					if (Integer.parseInt(now_day[1]) <= Integer.parseInt(day[1])) {
						String[] now_time = now_cus[1].split(":");

						if (Integer.parseInt(now_time[0]) <= Integer.parseInt(time[0])) {
							if (Integer.parseInt(now_time[1]) <= Integer.parseInt(time[1])) {
								if (Integer.parseInt(now_time[2]) <= Integer.parseInt(time[2])) {
									check = true;
									int z = Integer.parseInt(day[0]) - Integer.parseInt(now_day[0]);
									int x = Integer.parseInt(day[1]) - Integer.parseInt(now_day[1]);
									int v = Integer.parseInt(time[0]) - Integer.parseInt(now_time[0]);
									int c = Integer.parseInt(time[1]) - Integer.parseInt(now_time[1]);
									int b = Integer.parseInt(time[2]) - Integer.parseInt(now_time[2]);
									
									
									String maxz= "" +z+x+v+c+b;
									
									if(max < Integer.parseInt(maxz)) {
										max = Math.max(max, Integer.parseInt(maxz));
										maxk = j;
									}
									
									break;
								}
							}
						}
					}
				}

			}
			
			if(check) {
			}

		}
	}

}
