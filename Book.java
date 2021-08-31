import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author maxhartel
 *This class represents a book object
 */

public class Book implements BookInterface{
	private String title = null;
	private String author = null;
	private String fileName = null;
	private String genre = null;
	private String text;
	private String bookString;
	private ArrayList<String> validTester;
	private boolean valid;
	private File file;
	
//constructor takes title and author strings as parameters and uses them to initialize instance variables
	public Book(String title, String author){
		
		this.title = title;
		this.author = author;		
	}
	
//returns the  title of the book as a string
	@Override
	public String getTitle() {
		return this.title;
	}

//takes a string as a parameter and sets the title of the book object to that string
	@Override
	public void setTitle(String title) {
		this.title = title;
		
	}

//returns the author of the book as a string
	@Override
	public String getAuthor() {
		return this.author;
	}
	
//takes a string as a parameter and sets the author of the book object to that string
	@Override
	public void setAuthor(String author) {
		this.author= author;
		
	}

//returns the genre of the book as a string
	@Override
	public String getGenre() {
		return this.genre;
	}

//takes a string as a parameter and sets the genre of the book object to that string
	@Override
	public void setGenre(String genre) {
		this.genre = genre;
		
	}

//returns the file name of the book as a string
	@Override
	public String getFilename() {
		return this.fileName;
	}

//takes a string as a parameter and sets the file name of the book object to that string
	@Override
	public void setFilename(String filename) {
		this.fileName = filename;
		
	}

// Returns true if none of the attributes are null and the referenced filename exists, otherwise returns false.
	@Override
	public boolean isValid() {
		valid = true;
		validTester = new ArrayList<>();
		validTester.add(this.title);
		validTester.add(this.genre);
		validTester.add(this.author);
		validTester.add(this.fileName);
		
		for(String t : validTester) {
			if(t == null) {
				valid  = false;
			}
		}
		file = new File(this.fileName);
		try {
			Scanner fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			valid = false;
		}
		
		
		return valid;
	}

//Return a String that contains the text contents of the file referenced by the filename attribute.
	@Override
	public String getText() {
		text = "";
		file = new File(this.fileName);
		
		try {
			Scanner fileScan = new Scanner(file);
			while(fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				this.text = this.text.concat("\n" + line);
			}
			
		} catch (FileNotFoundException e) {
			this.text = "The File is unable to be opened";
		}
		return text;
	}
	
//modifies the default  toString method for the object book
	public String toString() {
		bookString = "";
		bookString ="Title: " + this.title + ",  Author: " + this.author + ",  Genre: " + this.genre + ",  File: " + 
		this.fileName;
		return bookString;
	}
	

}







