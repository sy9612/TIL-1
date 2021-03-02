package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class 여행경로 {
	private static Map<String, ArrayList<String>> map;
	private static String[] answer;
	static int cnt;
	public static void main(String[] args) {
		String[][] tickets = {
				{"ICN","2"}, {"ICN","3"},{"3","ICN"}
//				{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}	
//				{ "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
//				{ "ATL", "SFO" } 
//				
		};

		map = new HashMap<>();
		answer = new String[tickets.length+1];
		cnt = 0;

		for (int i = 0; i < tickets.length; i++) {

			if (map.containsKey(tickets[i][0])) {
				ArrayList<String> al = map.get(tickets[i][0]);
				al.add(tickets[i][1]);
				map.replace(tickets[i][0], al);
			} else {
				ArrayList<String> al = new ArrayList<>();
				al.add(tickets[i][1]);
				map.put(tickets[i][0], al);
			}
		}
		dfs("ICN");
		System.out.println(Arrays.toString(answer));

	}

	private static void dfs(String st) {
		ArrayList<String> al = map.get(st);
		answer[cnt++] = st;
		
		for (int i = 0; i < al.size(); i++) {
			
		}
	}
}
