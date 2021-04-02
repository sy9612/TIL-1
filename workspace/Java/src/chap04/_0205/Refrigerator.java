package chap04._0205;

public class Refrigerator {
	int num;
	String name;
	int price;
	int BJ_Hong;
	int l;

	Refrigerator() {};

	public Refrigerator(int num, String name, int price, int BJ_Hong, int l) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.BJ_Hong = BJ_Hong;
		this.l = l;
	};

	public String toString() {
		return num + "|" + name + "|" + price + "|" + BJ_Hong + "|" + l;
	}
}
