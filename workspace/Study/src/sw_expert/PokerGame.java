package sw_expert;

import java.util.*;

public class PokerGame {
	static String card[];
	static char suit[];
	static int rank[];
	static int check[];
	static int checkr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			card = new String[5];
			suit = new char[5];
			rank = new int[5];
			check = new int[100];
			checkr = new int[30];
			for (int i = 0; i < 5; i++) {
				card[i] = sc.next();
				suit[i] = card[i].charAt(0);
				check[suit[i]]++;
				rank[i] = card[i].charAt(1) - '0';
				if (rank[i] == 'A' - '0') {
					rank[i] = 1;
				} else if (rank[i] == 'J' - '0') {
					rank[i] = 11;
				} else if (rank[i] == 'Q' - '0') {
					rank[i] = 12;
				} else if (rank[i] == 'K' - '0') {
					rank[i] = 13;
				}else if(rank[i] == 'T' - '0') {
					rank[i] = 10;
				}

				checkr[rank[i]]++;
				checkr[rank[i] + 13]++;
			}

			boolean a = false;
			if (check['D'] >= 5 || check['H'] >= 5 || check['C'] >= 5 || check['S'] >= 5) {
				int cnt = 0;
				for (int i = 1; i <= 14; i++) {
					if (checkr[i] >= 1) {
						cnt++;
						if (cnt == 5)
							break;
					} else {
						cnt = 0;
					}
				}

				if (cnt == 5) {
					System.out.println("Straight Flush");
					a = true;
				}
			} 
			if(!a){
				// four of a kind
				boolean fourofakind = false;
				boolean fullhouse3 = false;
				int fullhouse2 = 0;
				for (int i = 1; i <= 13; i++) {
					if (checkr[i] >= 4)
						fourofakind = true;
					else if (checkr[i] == 3)
						fullhouse3 = true;
					else if (checkr[i] == 2)
						fullhouse2++;
				}
				if (fourofakind)
					System.out.println("Four of a Kind");

				else {
					// Full house
					if (fullhouse3 && fullhouse2 > 0) {
						System.out.println("Full House");
					}

					else {
						// Flush
						if (check['D'] == 5 || check['H'] == 5 || check['C'] == 5 || check['S'] == 5) {
							System.out.println("Flush");
						}

						// Straight
						else {
							int cnt = 0;
							for (int i = 1; i <= 14; i++) {
								if (checkr[i] >= 1) {
									cnt++;
									if (cnt == 5)
										break;
								} else {
									cnt = 0;
								}
							}
							
							boolean three = false;
							for(int i=1; i<=13; i++) {
								if(checkr[i] == 3) {
									three = true;
									break;
								}
							}

							if (cnt == 5)
								System.out.println("Straight");
							else if (three) {
								System.out.println("Three of a kind");
							} else if (fullhouse2 == 2) {
								System.out.println("Two pair");
							} else if (fullhouse2 == 1) {
								System.out.println("One pair");
							} else
								System.out.println("High card");
						}
					}

				}
			}

		}
	}
}
