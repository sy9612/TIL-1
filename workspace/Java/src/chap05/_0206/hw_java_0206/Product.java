package chap05._0206.hw_java_0206;

public class Product {
	private int num;
	private String name;
	private int price;
	private int BJ_Hong;
	
	public Product(int num, String name, int price, int bJ_Hong) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		BJ_Hong = bJ_Hong;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBJ_Hong() {
		return BJ_Hong;
	}
	public void setBJ_Hong(int bJ_Hong) {
		BJ_Hong = bJ_Hong;
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", BJ_Hong=" + BJ_Hong + "]";
	}
	
	
}
