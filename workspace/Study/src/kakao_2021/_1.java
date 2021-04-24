package kakao_2021;

import java.util.LinkedList;

public class _1 {
	public static void main(String[] args) {
//		int[] gift_cards = {4, 5, 3, 2, 1};
//		int[] wants = {2, 4, 4, 5, 1};
		
		int[] gift_cards = {5, 4, 5, 4, 5};
		int[] wants = {1, 2, 3, 4, 5};
		
		System.out.println(solution(gift_cards, wants));
	}
	public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        
        
        int[] arr = new int[100001];
 
        
        
        for (int i = 0; i < gift_cards.length; i++) {
        	arr[gift_cards[i]]++;
		}
        
        for (int i = 0; i < wants.length; i++) {
			if(arr[wants[i]] != 0) {
				arr[wants[i]]--;
			}
			else answer++;
		}
        
        return answer;
    }
}
