package chap04._0205;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	Book(){};
	Book(String isbn, String title, String author, String publisher, int price, String desc){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	};
	
	public String toString() {
		return isbn + "|" + title + "|" + author + "|" + publisher + "|" + price + "|" + desc;
	}
}
