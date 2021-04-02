package sw_expert._0121;
//package BASIC._0121.sw_expert;
///* �ܹ����� ���� ���� ������ Į�θ��� �־���
// * Į�θ��� Ư�� ���� ���� �ʴ� ������ ��Ḧ ������ �ְ��� ���� ������ ���� ���� ã�� ����
// * */
//
//import java.util.Scanner;
//
//public class 햄버거_다이어트 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int T = sc.nextInt();
//		
//		for() {
//			for(int i= 0; i<cnt; i++) {
//				score[i] = sc.nextInt();
//				cal[i] = sc.nextInt();
//			}
//			dfs(cal. score, 0, 0, 0, maxCal);
//			System.out.println('#' + tc + " "+ max);
//		}
//	}
//	
//	static int max = 0;
//	static void dfs(int[] cal, int[] score, int cur_cal, int cur_score, int idx, int maxCal) {
//		if(cur_cal>=maxCal)
//			return;
//		if(cur_score>max)
//			max = cur_score;
//		if(idx==cal.length)
//			return;
//		
//		dfs(cal, score, cur_cal, cur_score, idx+1, maxCal); //��Ḧ ����
//		dfs(cal, score, cur_cal + cal[idx], cur_score + score[idx], idx+1, maxCal); //��Ḧ ����
//	}
//}
