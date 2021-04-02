package chap05._0206.hw_java_0206;

public class TV extends Product{
	private int inch;
	private int type;
	public TV(int num, String name, int price, int bJ_Hong, int inch, int type) {
		super(num, name, price, bJ_Hong);
		this.inch = inch;
		this.type = type;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public int getType() {
		return type;
	}
	@Override
	public String toString() {
		return "TV [" + "상품번호=" + getNum() + ", 이름=" + getName()
				+ ", 가격=" + getPrice() + ", 수량=" + getBJ_Hong() + ", 인치="+inch +", 타입=" + type + "]";
	}
	public void setType(int type) {
		this.type = type;
	}
}
