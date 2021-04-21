package Programmers;

public class 월간챌린지_1 {
	public static void main(String[] args) {
		solution({4, 7 ,2}, {true, false, true});
	}
	
	 public int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        
	        for (int i = 0; i < signs.length; i++) {
				if(!signs[i]) {
					answer -= absolutes[i];
				}
				else
					answer += absolutes[i];
			}
	        
	        return answer;
	    }
}
