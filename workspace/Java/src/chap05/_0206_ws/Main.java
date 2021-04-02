package chap05._0206_ws;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager man = new Manager();

		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("항목을 고르세요\n1. 입력\n2. 수정\n3. 삭제\n4. 전체조회\n5. isbn으로 찾기\n6. 종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("1. Book 2. Magazine");
				int m = sc.nextInt();
				if (m == 1) {
					System.out.println("isbn, title, publisher, author, price, desc");
					String isbn = sc.next();
					String title = sc.next();
					String publisher = sc.next();
					String author = sc.next();
					int price = sc.nextInt();
					String desc = sc.next();
					man.insert(isbn, title, publisher, author, price, desc);
				} else if (m == 2) {
					System.out.println("isbn, title, publisher, author, price, desc, year, month");
					String isbn = sc.next();
					String title = sc.next();
					String publisher = sc.next();
					String author = sc.next();
					int price = sc.nextInt();
					String desc = sc.next();
					int year = sc.nextInt();
					int month = sc.nextInt();
					man.insert(isbn, title, publisher, author, price, desc, year, month);
				}
				break;
			case 2:
				System.out.println("1. Book 2. Magazine");
				int m1 = sc.nextInt();
				if (m1 == 1) {
					System.out.println("isbn, title, publisher, author, price, desc");
					String isbn1 = sc.next();
					String title1 = sc.next();
					String publisher1 = sc.next();
					String author1 = sc.next();
					int price1 = sc.nextInt();
					String desc1 = sc.next();
					man.update(isbn1, title1, publisher1, author1, price1, desc1);
				} else if (m1 == 2) {System.out.println("isbn, title, publisher, author, price, desc, year, month");
				
					String isbn = sc.next();
					String title = sc.next();
					String publisher = sc.next();
					String author = sc.next();
					int price = sc.nextInt();
					String desc = sc.next();
					int year = sc.nextInt();
					int month = sc.nextInt();
					man.update(isbn, title, publisher, author, price, desc, year, month);
				}

				break;

			case 3:
				String title11 = sc.next();
				man.delete(title11);
				break;

			case 4:
				man.serch();
				break;

			case 5:
				String s = sc.next();
				man.search(s);
				break;

			case 6:
				loop = false;
				break;

			default:
				break;
			}
		}
	}

}
