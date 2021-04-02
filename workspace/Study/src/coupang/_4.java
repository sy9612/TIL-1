package coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _4 {
	public static void main(String[] args) {
		String depar = "ULSAN";
		String hub = "SEOUL";
		String dest = "BUSAN";
		String[][] roads = { {"SEOUL","DAEJEON"},{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","ULSAN"},{"DAEJEON","BUSAN"},{"GWANGJU","BUSAN"} };

		int answer = -1;
		HashMap<String, ArrayList<String>> hs = new HashMap<>();
		for (int i = 0; i < roads.length; i++) {
			if (hs.containsKey(roads[i][0])) {
				ArrayList<String> al = new ArrayList<>();
				al = hs.get(roads[i][0]);
				al.add(roads[i][1]);
				hs.replace(roads[i][0], al);
			} else {
				ArrayList<String> al = new ArrayList<>();
				al.add(roads[i][1]);
				hs.put(roads[i][0], al);
			}
		}
		cnt = 0;
		nara = new HashSet<>();
		dfs(depar, hub, dest, hs, false);
		
		answer = cnt;
	
		System.out.println(answer);
	}

	static int cnt;
	static HashSet<String> nara;
	private static void dfs(String now, String hub, String dest, HashMap<String, ArrayList<String>> hs, boolean ok) {
		// TODO Auto-generated method stub
		
		if(now.equals(dest)) {
			if(ok)
				cnt++;
			nara.remove(now);
			return;
		}
		
		if(now.equals(hub)) {
			ok = true;
		}
		
		for (int i = 0; i < hs.get(now).size(); i++) {
			if(!nara.contains(hs.get(now).get(i))) {
				dfs(hs.get(now).get(i), hub, dest, hs, ok);
				if(hs.get(now).get(i).equals(hub)) {
					ok = false;
				}
				nara.remove(hs.get(now).get(i));
			}
		}
		
	}
	
	
}
