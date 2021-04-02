package chap02;

public class Lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			int sign = 0;
			int dit = (int)(Math.random()*100)%45 + 1;
			for(int j=0; j<i; j++)
			{
				if(dit == lotto[j]) {
					sign = 1;
					i--;
					break;
				}
			}
			if(sign == 0) {
				lotto[i] = dit;
				System.out.println(lotto[i]+" ");
			}

		}
	}

}
