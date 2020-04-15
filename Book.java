// Book class containing private book attributes and public methods for accessing book attributes

public class Book extends BookDatabase{	//inherits from BookDatabase abstract class
	
	private int id;		//fields made private
	private String Title;
	private String Author;
	private int Qty;
	
	public Book () {	
	}
	
	// constructor 
	public Book(int id, String title, String author, int qty) {
		this.id = id;
		this.Title = title;
		this.Author = author;
		this.Qty = qty;	
	}
	
	//setters and getters
	public int getId() {	
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	
}
