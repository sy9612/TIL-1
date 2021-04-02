package chap05._0206_ws;

public class Manager{
	private Book[] books;
	private int Max = 10;
	private int idx=0;
	
	private Magazine[] Magazins;
	private int M_idx = 0;
	
	public Manager() {
		books = new Book[Max];
		Magazins = new Magazine[Max];
	}
	
	public void insert(String isbn, String title, String publisher, String author, int price, String desc) {
		if(idx>=Max)
		{
			System.out.println("가득참");
			return;
		}
		books[idx] = new Book(isbn, title, publisher, author, price, desc);
		idx++;
	}
	public void insert(String isbn, String title, String publisher, String author, int price	, String desc, int year,
			int month) {
		if(M_idx>=Max)
		{
			System.out.println("가득참");
			return;
		}
		Magazins[M_idx] = new Magazine(isbn, title, publisher, author, price, desc,year,month);
		M_idx++;
	}
	public void delete(String title) {
		for(int i=0; i<idx; i++) {
			if(books[i].getTitle().equals(title))
			{
				books[i] = books[idx-1];
				idx--;
			}
		}
		for(int i=0; i<M_idx; i++) {
			if(Magazins[i].getTitle().equals(title)) {
				Magazins[i] = Magazins[M_idx-1];
				M_idx--;
			}
		}
	}
	
	public void update(String isbn, String title, String author, String publisher, int price, String desc) {
		System.out.println("책제목 기준으로 업데이트를 진행합니다.");
		for (int i = 0; i < idx; i++) {
			if (books[i].getTitle().equals(title)) {
				books[i].setIsbn(isbn);
				books[i].setAuthor(author);
				books[i].setPrice(price);
				books[i].setPublisher(publisher);
				books[i].setDesc(desc);
				break;
			}
		}
	}
	public void update(String isbn, String title, String publisher, String author, int price	, String desc, int year,
			int month) {
		System.out.println("책제목 기준으로 업데이트를 진행합니다.");
		for (int i = 0; i < idx; i++) {
			if (Magazins[i].getTitle().equals(title)) {
				Magazins[i].setIsbn(isbn);
				Magazins[i].setAuthor(author);
				Magazins[i].setPrice(price);
				Magazins[i].setPublisher(publisher);
				Magazins[i].setDesc(desc);
				Magazins[i].setYear(year);
				Magazins[i].setMonth(month);
				break;
			}
		}
	}

	public void serch() {
		for(int i=0; i<idx; i++)
			System.out.println(books[i].toString());
		for(int i=0; i<M_idx; i++)
			System.out.println(Magazins[i].toString());
		
	}

	public void search(String s) {
		for(int i=0; i<idx; i++) {
			if(books[i].getIsbn().equals(s))
			{
				System.out.println(books[i].toString());
			}
		}
		for(int i=0; i<M_idx; i++) {
			if(Magazins[i].getIsbn().equals(s)) {
				System.out.println(Magazins[i].toString());
			}
		}
	}
	
}
