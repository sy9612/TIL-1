package chap05._0206.hw_java_0206;

import java.util.Scanner;

public class ProductTest {
	
	public static void main(String[] args) {
		ProductMgr man = new ProductMgr();

		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("항목을 고르세요\n1. 입력 2. 검색 3. 삭제 4. 전체 재고 금액 5. 종료");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("1. TV 2. Refrigerator");
				int m = sc.nextInt();
				
				System.out.print("상품 번호: ");
				int num = sc.nextInt();
				System.out.print("상품 이름: ");
				String name = sc.next();
				System.out.print("상품 가격: ");
				int price = sc.nextInt();
				System.out.print("수량: ");
				int BJ_Hong = sc.nextInt();
				if (m == 1) {
					System.out.print("TV 인치: ");
					int inch = sc.nextInt();
					System.out.print("TV 타입: ");
					int type = sc.nextInt();
					man.insert(num, name, price, BJ_Hong, inch, type);
				} else if (m == 2) {
					System.out.print("용량: ");
					int l = sc.nextInt();
					man.insert(num, name, price, BJ_Hong, l);
				}
				break;
			case 2:
				System.out.println("1. 전체 검색 2. 상품 번호 검색 3. 상품명으로 검색 4. TV 검색 5. Refrigerator검색");
				int sea = sc.nextInt();
				switch (sea) {
				case 1:
					man.search(true,true);
					break;
				case 2:
					int number = sc.nextInt();
					man.search(number);
					break;
				case 3:
					String n1 = sc.next();
					man.search(n1);
					break;
				case 4:
					man.search(true, false);
					break;
				case 5:
					man.search(false, true);
				default:
					break;
				}
				break;

			case 3:
				System.out.println("상품번호를 입력하세요.");
				man.delete(sc.nextInt());
				System.out.println("삭제완료");
				break;

			case 4:
				man.total();
				break;
				
			case 5:
				loop = false;
				break;

			default:
				break;
			}
		}
	}
}
