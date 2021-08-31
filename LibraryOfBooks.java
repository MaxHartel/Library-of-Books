import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author maxhartel
 *Displays a basic console for the user and lets them choose between different
 *options on how to interact with the library
 */

public class LibraryOfBooks {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		String input;
		char inputChar;
		int index;
		Library library = new Library();
		File file;
		String title;
		String author;
		String genre;
		String fileName;
		scan.useDelimiter("\n");

		System.out.println("*****************************");
		System.out.println("*      Program Menu         *");
		System.out.println("*****************************");
		System.out.println("(P)rint Library(with index values)");
		System.out.println("(R)ead a book from the Library");
		System.out.println("(D)elete a book from the Library");
		System.out.println("(A)dd a book to the Library");
		System.out.println("(Q)uit");

		
		//continues to prompt the user for input until the quit command is entered
		while (loop) {
			System.out.println("\nPlease enter a command (press 'm' for Menu):");
			input = scan.next();
			input = input.toLowerCase();
			inputChar = input.charAt(0);

			switch (inputChar) {
// case r lets the user read the book by printing it to the console
			case 'r':
				System.out.println("Please enter the index of the book you would like to read");
				input = scan.next();
				index = Integer.parseInt(input);
				
				if(index >= library.getBooks().size() || index <= 0) {
					Book book = library.getBook(index);
					
					if(book.isValid()) {
						System.out.println(book.getText());
					}else {
						System.out.println("This book is currently unavailable");
					}
				
				}else {
					System.out.println("Invadid Index");
				}

				break;
//case 'm' displays a menu to the user
			case 'm':
				System.out.println("*****************************");
				System.out.println("*      Program Menu         *");
				System.out.println("*****************************");
				System.out.println("(P)rint Library(with index values)");
				System.out.println("(R)ead a book from the Library");
				System.out.println("(D)elete a book from the Library");
				System.out.println("(A)dd a book to the Library");
				System.out.println("(Q)uit");
				break;
// case d lets the user delete a book from the library
			case 'd':
				System.out.println("Please enter the index of the book you would like to delete");
				input = scan.next();
				index = Integer.parseInt(input);
				
				if(index >= library.getBooks().size() || index <= 0) {
				library.removeBook(index);
				System.out.println("Book has been Deleted");
				}else {
					System.out.println("Invadid Index");
				}
				
				break;
// case a lets the user add a book to the library
			case 'a':
				System.out.println("Enter the Title of the Book");
				title = scan.next();
				
				System.out.println("Enter the Author of the Book");
				author = scan.next();
				
				System.out.println("Enter the Genre of the Book");
				genre = scan.next();
				
				System.out.println("Enter the File Name of the Book");
				fileName = scan.next();
				
				Book book = new Book(title,author);
				book.setGenre(genre);
				book.setFilename(fileName);
				
				library.addBook(book);

				break;
// case p prints the contents of the library to the console
			case 'p':
				System.out.print(library.toString());

				break;
// case q quits the loop
			case 'q':
				loop = false;
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid input!");
			}
		}
		scan.close();
	}
}
