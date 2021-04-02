package chap04._0205;

public class Manager {
	Book[] book_arr;
	Magazine[] magazine_arr;
	int book_cnt = 0;
	int magazine_cnt = 0;
	int max = 10;

	Manager() {
		book_arr = new Book[max];
		magazine_arr = new Magazine[max];
	}

	void insert(String isbn, String title, String author, String publisher, int price, String desc) {
		if(book_cnt>=max)
			return;
		Book book = new Book(isbn, title, author, publisher, price, desc);
		book_arr[book_cnt] = book;
		book_cnt++;
	}

	void insert(String isbn, String title, String author, String publisher, int year, int month, int price, String desc) {
		if(magazine_cnt>=max)
			return;
		Magazine magazine = new Magazine(isbn, title, author, publisher, year, month, price, desc);
		magazine_arr[magazine_cnt] = magazine;
		magazine_cnt++;
	}

	void update(String isbn, String title, String author, String publisher, int price, String desc) {
		for (int i = 0; i < book_cnt; i++) {
			if (book_arr[i].title.equals(title)) {
				book_arr[i].isbn = isbn;
				book_arr[i].author = author;
				book_arr[i].publisher = publisher;
				book_arr[i].price = price;
				book_arr[i].desc = desc;

				break;
			}
		}
	}

	void update(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		for (int i = 0; i < magazine_cnt; i++) {
			if (magazine_arr[i].title.equals(title)) {
				magazine_arr[i].isbn = isbn;
				magazine_arr[i].author = author;
				magazine_arr[i].publisher = publisher;
				magazine_arr[i].year = year;
				magazine_arr[i].month = month;
				magazine_arr[i].price = price;
				magazine_arr[i].desc = desc;
				break;
			}
		}
	}


	void delete(String title, int type) {
		
		if (type == 1) {
			if(book_cnt <1)
				return;
			for (int i = 0; i < book_cnt; i++) {
				if (book_arr[i].title.equals(title)) {
					book_arr[i] = book_arr[book_cnt - 1];
					book_cnt--;
					break;
				}
			}
		}else {
			if(magazine_cnt <1)
				return;
			for (int i = 0; i < magazine_cnt; i++) {
				if (magazine_arr[i].title.equals(title)) {
					magazine_arr[i] = magazine_arr[magazine_cnt - 1];
					magazine_cnt--;
					break;
				}
			}
		}
	}

	void list(int type) {
		if (type == 1) {
			for(int i=0; i<book_cnt; i++)
				System.out.println(book_arr[i].toString());
		} else {
			for(int i=0; i<magazine_cnt; i++)
				System.out.println(magazine_arr[i].toString());
		}
	}
}
