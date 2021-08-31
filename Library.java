import java.util.ArrayList;

/**
 * 
 * @author maxhartel
 *Manages an arrayList that represents a library of book objects
 */

public class Library implements LibraryInterface {
	private ArrayList<Book> books;
	private String bookString;
	private String library;
	
//constructor does not take parameters, and initializes the ArrayList
	public Library(){
		books = new ArrayList<Book>();
	}

// returns the arrayList "books"
	@Override
	public ArrayList<Book> getBooks() {
		
		return books;
	}
	
//takes a book object as  a parameter and adds it to the books ArrayList
	@Override
	public void addBook(Book newBook) {
		books.add(newBook);
		
	}

//takes an integer as a parameter and removes the book object at that index from the ArrayList books
	@Override
	public void removeBook(int index) {
		books.remove(index);
		
	}
	
//takes an integer as a parameter and returns the book object at that index from the ArrayList books
	@Override
	public Book getBook(int index) {
		Book book = books.get(index);
		return book;
	}
	
//reformats the standard toString for  the arrayList Library
	public String toString() {
		library= "";
		int count = 0;
		
		for(Book b : books) {
			
			bookString = "\n" + b.toString() + "  Index: " + count;
			
			library = library.concat(bookString);
			count ++;	
		}
		
		return library;
	}

}
