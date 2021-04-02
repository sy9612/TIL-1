package chap05._0206.hw_java_0206;

public class Refrigerator extends Product{
	private int l;

	public Refrigerator(int num, String name, int price, int bJ_Hong, int l) {
		super(num, name, price, bJ_Hong);
		this.l = l;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return "Refrigerator [" + "상품번호=" + getNum() + ", 이름=" + getName()
				+ ", 가격=" + getPrice() + ", 수량=" + getBJ_Hong() + ", 용량=" + l + "]" ;
	}
	
}
