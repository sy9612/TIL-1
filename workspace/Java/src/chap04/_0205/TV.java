package chap04._0205;

public class TV {
	int num;
	String name;
	int price;
	int BJ_Hong;
	int inch;
	int type;
	
	TV(){};

	public TV(int num, String name, int price, int BJ_Hong, int inch, int type) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.BJ_Hong = BJ_Hong;
		this.inch = inch;
		this.type = type;
	};
	public String toString() {
		return num + "|" + name + "|" + price + "|" + BJ_Hong + "|" + inch + "|" + type;
	}
}
