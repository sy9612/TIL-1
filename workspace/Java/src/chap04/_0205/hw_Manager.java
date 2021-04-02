package chap04._0205;

public class hw_Manager {
	TV[] TV_arr;
	Refrigerator[] Refrigerator_arr;
	int TV_cnt = 0;
	int Refrigerator_cnt = 0;
	int max = 10;

	hw_Manager() {
		TV_arr = new TV[max];
		Refrigerator_arr = new Refrigerator[max];
	}

	void insert(int num, String name, int price, int BJ_Hong, int inch, int type) {
		if (TV_cnt >= max)
			return;
		TV tv = new TV(num, name, price, BJ_Hong, inch, type);
		TV_arr[TV_cnt] = tv;
		TV_cnt++;
	}

	void insert(int num, String name, int price, int BJ_Hong, int l) {
		if (Refrigerator_cnt >= max)
			return;
		Refrigerator refrigerator = new Refrigerator(num, name, price, BJ_Hong, l);
		Refrigerator_arr[Refrigerator_cnt] = refrigerator;
		Refrigerator_cnt++;
	}
	
	void list(int type) {
		if (type == 1) {
			for(int i=0; i<TV_cnt; i++)
				System.out.println(TV_arr[i].toString());
		} else {
			for(int i=0; i<Refrigerator_cnt; i++)
				System.out.println(Refrigerator_arr[i].toString());
		}
	}
}
