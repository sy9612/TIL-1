package devmatching;

import java.util.Arrays;
import java.util.HashMap;

public class _3 {
	public static void main(String[] args) {
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int amount[] = { 12, 4, 2, 5, 10 };
		
//		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
//		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
//		String[] seller = { "sam", "emily", "jaimie", "edward" };
//		int amount[] = { 2, 3, 5, 4 };
		
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		
		HashMap<String, Integer> hs = new HashMap<>();
		
		//왜 해쉬를 map 사용? 자식 -> 부모의 번호를 저장하기 위해
		for (int i = 0; i < enroll.length; i++) {
			hs.put(enroll[i], i);
		}
		
		// 부모 올라가면서 이익을 배분
		for (int i = 0; i < seller.length; i++) {
			int cur = hs.get(seller[i]);
			int amt = amount[i]*100;
			
			// 부모가 없다면 종료
			while(referral[cur] != "-") {
				// amt가 10보다 크면 부모에게 줄 수 있음
				if(amt / 10 > 0) {
					// 현재위치의 사람에게 부모에게 줄만큼의 이익을 제거
					answer[cur] += amt - amt/10;
					
					// 부모들이 나눠가져야 할 돈
					amt /= 10;
					
					// 만약에 부모가 존재한다면, 현재 위치는 부모가 된다.
					if(hs.containsKey(referral[cur]))
						cur = hs.get(referral[cur]);
					else
						break;
				}
				// 10보다 작으면 자기가 다 가짐
				else {
					answer[cur] += amt;
					break;
				}
			}
			
			// 부모가 없을 때 예외 계산
			if(referral[cur] == "-") {
				if(amt / 10 > 0) {
					answer[cur] += amt - amt/10;
				}
				else {
					answer[cur] += amt;
				}
			}
			
		}
		
		return answer;
	}
}
