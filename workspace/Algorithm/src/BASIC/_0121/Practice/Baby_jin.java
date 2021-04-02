package BASIC._0121.Practice;

import java.util.Arrays;

public class Baby_jin {
	public static void main(String[] args) {
		int[] arr = { 1,9,8,2,7,3 };

		int[] card = new int[10];

		int[] new_arr = new int[6];

		for (int i = 0; i < arr.length; i++) {
			card[arr[i]]++;
		}
		int sign = 0;
		int new_arr_index = 0;

		for (int i = 0; i < card.length;) {
			sign = 0;
			if (card[i] >= 3) {
				new_arr[new_arr_index] = i;
				new_arr[new_arr_index + 1] = i;
				new_arr[new_arr_index + 2] = i;
				new_arr_index += 3;
				card[i] -= 3;

				sign = 1;
			}

			if (card[i] != 0 && i < card.length - 2) {
				if (card[i + 1] != 0 && card[i + 2] != 0) {
					new_arr[new_arr_index] = i;
					new_arr[new_arr_index + 1] = i + 1;
					new_arr[new_arr_index + 2] = i + 2;
					new_arr_index += 3;

					card[i]--;
					card[i + 1]--;
					card[i + 2]--;

					sign = 1;
				}
			}

			if (new_arr_index == 6)
				break;

			if (sign == 0) {
				i++;
			} else if (card[i] != 0) {
				i++;
			}

		}

		if (new_arr_index != 6)
			System.out.println("���̺����� �ƴմϴ�.");
		else {
			boolean result = isBabygin(new_arr);
			System.out.println(result ? "���̺����Դϴ�" : "���̺����� �ƴմϴ�.");
		}
		
	}
	
	static boolean isBabygin(int[] arr) {

		int t_cnt = 1;
		int r_cnt = 1;

		int[] front = Arrays.copyOfRange(arr, 0, 3);
		int[] back = Arrays.copyOfRange(arr, 3, 6);

		Arrays.sort(front);
		Arrays.sort(back);

		for (int i = 0; i < front.length - 1; i++) {
			if (front[i] == front[i + 1]) {
				t_cnt++;
			} else if (front[i + 1] - front[i] == 1) {
				r_cnt++;
			}
		}

		if (t_cnt == 3 || r_cnt == 3) {
			t_cnt = 1;
			r_cnt = 1;
			for (int i = 0; i < back.length - 1; i++) {
				if (back[i] == back[i + 1]) {
					t_cnt++;
				} else if (back[i + 1] - back[i] == 1) {
					r_cnt++;
				}
			}

			if (t_cnt == 3 || r_cnt == 3)
				return true;
		}

		return false;
	}

}
