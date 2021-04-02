package chap04._0205;

public class Magazine {
	String isbn;
	String title;
	String author;
	String publisher;
	int year;
	int month;
	int price;
	String desc;
	
	Magazine(){};
	Magazine(String isbn, String title, String author, String publisher, int year, int month, int price, String desc){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	};
	public String toString() {
		return isbn + "|" + title + "|" + author + "|" + publisher + "|" + price + "|" + desc + "|" + year + "." + month;
	}
}
