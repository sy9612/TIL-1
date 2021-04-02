//package Line2021;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * 1. 이름 == word 일치 검색 2. word가 많이 포함될수록 먼저 검색 1) word 개수가 같으면 wordㅏ가 앞에 있을 수록
// * 2) word가 등장하는 위치가 같다면 다음 위치 비교 3. 검색 순위가 같다면 id가 더 작은 인형 나열
// * 
// * @author 15com
// *
// */
//public class _4 {
//	public static void main(String[] args) {
//		String[] data = { "1 BROWN 0", "2 CONY 0", "3 DOLL 1", "4 DOLL 2", "5 LARGE-BROWN 3", "6 SMALL-BROWN 3",
//				"7 BLACK-CONY 4", "8 BROWN-CONY 4" };
//		String word = "BROWN";
//
//		solution(data, word);
//	}
//
//	static class Node {
//		int id;
//		String name;
//		int pid;
//
//		Node(int id, String name, int pid) {
//			this.id = id;
//			this.name = name;
//			this.pid = pid;
//		}
//	}
//
//	static class myName implements Comparable<myName> {
//		int id;
//		String name;
//		String word;
//
//		myName(int id, String name, String word) {
//			this.id = id;
//			this.name = name;
//			this.word = word;
//		}
//
//		@Override
//		public int compareTo(myName o) {
//
//			if (this.name.equals(this.word)) {
//				if (o.name.equals(this.word)) {
//					int a = -1;
//					int acnt = 0;
//					int b = -1;
//					int bcnt = 0;
//					for (int i = 0; i < this.name.length() - word.length(); i++) {
//						String buf = this.name.substring(i, i + word.length());
//						if (buf.equals(this.word)) {
//							if (a == -1)
//								a = i;
//							acnt++;
//						}
//					}
//					for (int i = 0; i < o.name.length() - word.length(); i++) {
//						String buf = o.name.substring(i, i + word.length());
//						if (buf.equals(o.word)) {
//							if (b == -1)
//								b = i;
//							bcnt++;
//						}
//					}
//
//					if (acnt > bcnt)
//						return -1;
//					else if (acnt < bcnt)
//						return 1;
//					else if (acnt == bcnt) {
//						if (a < b)
//							return -1;
//						else if (a > b)
//							return 1;
//						else
//							return this.id - o.id;
//
//					}
//				} else
//					return -1;
//			} else if (this.name.equals(this.word)) {
//				if (o.name.equals(this.word)) {
//					int a = -1;
//					int acnt = 0;
//					int b = -1;
//					int bcnt = 0;
//					for (int i = 0; i < this.name.length() - word.length(); i++) {
//						String buf = this.name.substring(i, i + word.length());
//						if (buf.equals(this.word)) {
//							if (a == -1)
//								a = i;
//							acnt++;
//						}
//					}
//					for (int i = 0; i < o.name.length() - word.length(); i++) {
//						String buf = o.name.substring(i, i + word.length());
//						if (buf.equals(o.word)) {
//							if (b == -1)
//								b = i;
//							bcnt++;
//						}
//					}
//
//					if (acnt > bcnt)
//						return -1;
//					else if (acnt < bcnt)
//						return 1;
//					else if (acnt == bcnt) {
//						if (a < b)
//							return -1;
//						else if (a > b)
//							return 1;
//						else
//							return this.id - o.id;
//
//					}
//				} else
//					return 1;
//
//			} else {
//				int a = -1;
//				int acnt = 0;
//				int b = -1;
//				int bcnt = 0;
//				for (int i = 0; i < this.name.length() - word.length(); i++) {
//					String buf = this.name.substring(i, i + word.length());
//					if (buf.equals(this.word)) {
//						if (a == -1)
//							a = i;
//						acnt++;
//					}
//				}
//				for (int i = 0; i < o.name.length() - word.length(); i++) {
//					String buf = o.name.substring(i, i + word.length());
//					if (buf.equals(o.word)) {
//						if (b == -1)
//							b = i;
//						bcnt++;
//					}
//				}
//
//				if (acnt > bcnt)
//					return -1;
//				else if (acnt < bcnt)
//					return 1;
//				else if (acnt == bcnt) {
//					if (a < b)
//						return -1;
//					else if (a > b)
//						return 1;
//					else
//						return this.id - o.id;
//				}
//			}
//			return 0;
//
//		}
//	}
//
//	public static String[] solution(String[] data, String word) {
//		String[] answer = {};
//
//		String[][] all = new String[data.length][3];
//
//		for (int i = 0; i < data.length; i++) {
//			all[i] = data[i].split(" ");
//		}
//
//		ArrayList<Node> point = new ArrayList<>();
//		ArrayList<Node> doll = new ArrayList<>();
//
//		int[] parents = new int[data.length + 1];
//
////		for(int i=1; i<=data.length; i++) {
////			parents[i] = i;
////		}
////		rank = new int[data.length+1];
//
//		for (int i = 0; i < data.length; i++) {
//			String[] st = data[i].split(" ");
//			if (data[i].contains("-")) {
//				doll.add(new Node(Integer.parseInt(st[0]), st[1], Integer.parseInt(st[2])));
//			} else
//				point.add(new Node(Integer.parseInt(st[0]), st[1], Integer.parseInt(st[2])));
//			parents[Integer.parseInt(st[0])] = Integer.parseInt(st[2]);
//		}
//
//		Queue<myName> rs = new LinkedList<>();
//		for (int i = 0; i < doll.size(); i++) {
//			if (doll.get(i).name.contains((word))) {
//				int ab = doll.get(i).id;
//				rs.add(new myName(doll.get(i).id, doll.get(i).name, word));
//			}
//		}
//		
//		
//		while(!rs.isEmpty()){
//			myName buf = rs.poll();
//			ArrayList<String> al = new ArrayList<>();
//			int go = buf.id;
//			while(true) {
//				if(parents[go] == 0)
//					break;
//				else {
//					go = parents[go];
//					if(doll.get(i))
//				}
//			}
//		}
//
//		System.out.println(Arrays.toString(parents));
//
//		return answer;
//	}
//
//}
