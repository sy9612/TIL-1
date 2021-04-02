package kakaotest;


public class _1 {
	
	public static void main(String[] args) {
		
		int num[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		String answer = solution(num, hand);
		System.out.println(answer);
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder ans = new StringBuilder();
		
		int[] positionL = {3,0};
		int[] positionR = {3,2};
		
		
		
		for (int cnt = 0; cnt < numbers.length; cnt++) {
			System.out.println(numbers[cnt]);
			if(numbers[cnt] == 1 || numbers[cnt] == 4 || numbers[cnt] == 7) {
				ans.append("L");
				if(numbers[cnt] == 1) {
					positionL[0] = 0;
					positionL[1] = 0;
				}
				else if(numbers[cnt] == 4) {
					positionL[0] = 1;
					positionL[1] = 0;
				}
				else if(numbers[cnt] == 7) {
					positionL[0] = 2;
					positionL[1] = 0;
				}
			}
			else if(numbers[cnt] == 3 || numbers[cnt] == 6 || numbers[cnt] == 9) {
				ans.append("R");
				
				if(numbers[cnt] == 3) {
					positionR[0] = 0;
					positionR[1] = 2;
				}
				else if(numbers[cnt] == 6) {
					positionR[0] = 1;
					positionR[1] = 2;
				}
				else if(numbers[cnt] == 9) {
					positionR[0] = 2;
					positionR[1] = 2;
				}
			}
			else {
				int[] p = new int[2];
				if(numbers[cnt] == 2) {
					p[0] = 0;
					p[1] = 1;
				}
				else if(numbers[cnt] == 5) {
					p[0] = 1;
					p[1] = 1;
				}
				if(numbers[cnt] == 8) {
					p[0] = 2;
					p[1] = 1;
				}
				if(numbers[cnt] == 0) {
					p[0] = 3;
					p[1] = 1;
				}
				
				int l = Math.abs(positionL[0] - p[0]) + Math.abs(positionL[1] - p[1]);
				int r = Math.abs(positionR[0] - p[0]) + Math.abs(positionR[1] - p[1]);
				if(l < r) {
					ans.append("L");
					positionL[0] = p[0];
					positionL[1] = p[1];
				}
				else if(r < l) {
					ans.append("R");

					positionR[0] = p[0];
					positionR[1] = p[1];
				}
				else {
					if(hand.equals("left")) {
						ans.append("L");
						positionL[0] = p[0];
						positionL[1] = p[1];
					}
					else {
						ans.append("R");
						positionR[0] = p[0];
						positionR[1] = p[1];
					}
				}
			}
		}
		
		return ans.toString();
	}
}
