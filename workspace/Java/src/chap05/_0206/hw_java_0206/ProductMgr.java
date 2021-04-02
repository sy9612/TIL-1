package chap05._0206.hw_java_0206;

public class ProductMgr {
	Product arr[];
	int cnt = 0;
	int max = 10;

	ProductMgr() {
		arr = new Product[max];
	}

	void insert(int num, String name, int price, int BJ_Hong, int inch, int type) {

		if (cnt >= max) {
			System.out.println("너무 많아요ㅠ^ㅠ");
			return;
		}
		Product tv = new TV(num, name, price, BJ_Hong, inch, type);
		arr[cnt] = tv;
		cnt++;
	}

	void insert(int num, String name, int price, int BJ_Hong, int l) {
		if (cnt >= max) {
			System.out.println("더 이상 담을 수 없어요...");
			return;
		}
		Product refrigerator = new Refrigerator(num, name, price, BJ_Hong, l);
		arr[cnt] = refrigerator;
		cnt++;
	}

	public void search(boolean b, boolean c) {
		// TODO Auto-generated method stub
		if (b == true) {
			for (int i = 0; i < cnt; i++) {
				if (arr[i] instanceof TV)
					System.out.println(arr[i].toString());
			}
		}
		if (c == true) {
			for (int i = 0; i < cnt; i++)
				if (arr[i] instanceof Refrigerator)
					System.out.println(arr[i].toString());
		}
	}

	public void search(int number) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cnt; i++) {
			if (arr[i].getNum() == number) {
				System.out.println(arr[i].toString());
			}
		}
	}

	public void search(String n1) {
		for (int i = 0; i < cnt; i++) {
				if (arr[i].getName().contains(n1)) {
					System.out.println(arr[i].toString());
				

			}

		}
	}

	public void delete(int nn) {
		for (int i = 0; i < cnt; i++) {
			if (arr[i].getNum() == nn) {
				arr[i] = arr[cnt - 1];
				cnt--;
			}
		}

	}

	public void total() {
		int to = 0;
		for (int i = 0; i < cnt; i++)
			to += arr[i].getPrice();

		int p = to / cnt;
		System.out.println("가격 평균: " + p);
	}
}
