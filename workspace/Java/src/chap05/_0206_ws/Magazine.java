package chap05._0206_ws;

public class Magazine extends Book{
	public Magazine(String isbn, String title, String publisher, String author, int pirce, String desc) {
		super(isbn, title, publisher, author, pirce, desc);
		// TODO Auto-generated constructor stub
	}
	public Magazine(String isbn, String title, String publisher, String author, int price	, String desc, int year,
			int month) {
		super(isbn, title, publisher, author, price, desc);
		this.year = year;
		this.month = month;
	}
	private int year;
	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", getYear()=" + getYear() + ", getMonth()=" + getMonth()
				+ ", getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle() + ", getPublisher()=" + getPublisher()
				+ ", getAuthor()=" + getAuthor() + ", getPrice()=" + getPrice() + ", getDesc()=" + getDesc() + "]";
	}
	private int month;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
}
