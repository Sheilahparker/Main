public class Book {

    String title;
    boolean borrowed;

   
    public Book(String bookTitle) {
      this.title = bookTitle;
      this.borrowed = false;
      
    }
   
    // constructor method for borrowed
    public void borrowed() {
       this.borrowed = true;
    }
   
    // Marks the book as not rented "Method"
    public void returned() {
    	this.borrowed = false; 
    }
   
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
    	return this.borrowed; 
    }
   
    // Returns the title of the book
    public String getTitle() {
        return this.title; 
    }

   
} 
