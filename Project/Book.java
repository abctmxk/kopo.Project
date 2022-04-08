package Project;

public class Book {

	private String BookISBN;
	private String BookTitle;
	private String BookAuthor;
	private String BookAvailable;
	private String BookKey;
	
	public Book() {};
	
	public Book(String bookISBN, String bookTitle, String bookAuthor, String BookKey) {
		super();
		this.BookISBN = bookISBN;
		this.BookTitle = bookTitle;
		this.BookAuthor = bookAuthor;
		this.BookKey = BookKey;
	}
	
	public String getBookISBN() {
		return BookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.BookISBN = bookISBN;
	}
	
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.BookTitle = bookTitle;
	}
	
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.BookAuthor = bookAuthor;
	}
	
	public String getBookAvailable() {
		return BookAvailable;
	}
	public void setBookAvailable(String bookAvailable) {
		this.BookAvailable = bookAvailable;
	}
	
	public String getBookKey() {
		return BookKey;
	}
	public void setBookKey(String bookKey) {
		this.BookKey = bookKey;
	}
	
	
}
