import java.util.*;

public class Library {
    // Add the missing implementation to this class

    private final String address; 
    private List<Book>books;
    
    public Library(String address) {
    	this.address = address;
    	this.books = new ArrayList<Book>();
    }	
    
    public void addBook(Book book) {
    	this.books.add(book);
    }
    public void borrowBook(String bookTitle) {	
    	boolean existBook = false;
    	for(Book book : this.books) {
    		if(book.getTitle().equals(bookTitle)){
    			System.out.println("Sorry, this book is not available"); 
    			}else {
    				book.borrowed();
    				System.out.println("You have just rented this book");
    			}
    		}
    }
    public void returnBook(String bookTitle) {  
    	boolean existBook = false;
    	for(Book book : this.books) {
    		if(book.getTitle().equals(bookTitle)) {
    			if(book.isBorrowed()) {
    				book.returned();
    				System.out.println("This book has been returned");
    			}
    			existBook = true;
    			break;
    		}
    	}
    	if(!existBook) {
    		System.out.println("This book has not been returned");
    	}
    }
    
    public void printOpeningHours() {	
    	System.out.println("Library opens at 9 Am to 5 Pm");
    }
    public void printAddress() {
    	System.out.println(" "+ this.address);
    }
    public void printAvailableBooks() {
    	boolean booksAvailableInStore = false;
    	for(Book book : this.books) {
    		if(!book.isBorrowed()) {
    			System.out.println(" "+ book.getTitle());
    		}
    	}
    	if(! booksAvailableInStore) {
    		System.out.println("No books avaialble in store");
    	}
    }
    
    
} 