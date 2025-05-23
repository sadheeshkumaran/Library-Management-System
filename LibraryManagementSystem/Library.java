package LibraryManagementSystem;
	import java.util.ArrayList;
	import java.util.List;

	public class Library {
	    private List<Book> books;

	    // Constructor
	    public Library() {
	        books = new ArrayList<>();
	    }

	    // Add a book to the library
	    public void addBook(Book book) {
	        books.add(book);
	        System.out.println("Book added: " + book.getTitle());
	    }

	    // Remove a book from the library
	    public void removeBook(String isbn) {
	        books.removeIf(book -> book.getIsbn().equals(isbn));
	        System.out.println("Book with ISBN " + isbn + " removed.");
	    }

	    // Search for a book by title, author, or ISBN
	    public void searchBook(String query) {
	        boolean found = false;
	        for (Book book : books) {
	            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query) || book.getIsbn().equalsIgnoreCase(query)) {
	                System.out.println("Found: " + book);
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No book found matching the query: " + query);
	        }
	    }

	    // Issue a book to a user
	    public void issueBook(String isbn) {
	        for (Book book : books) {
	            if (book.getIsbn().equals(isbn)) {
	                if (book.isAvailable()) {
	                    book.setAvailable(false);
	                    System.out.println("Book issued: " + book.getTitle());
	                } else {
	                    System.out.println("Book is already issued.");
	                }
	                return;
	            }
	        }
	        System.out.println("Book with ISBN " + isbn + " not found.");
	    }

	    // Return a book to the library
	    public void returnBook(String isbn) {
	        for (Book book : books) {
	            if (book.getIsbn().equals(isbn)) {
	                if (!book.isAvailable()) {
	                    book.setAvailable(true);
	                    System.out.println("Book returned: " + book.getTitle());
	                } else {
	                    System.out.println("Book is already available.");
	                }
	                return;
	            }
	        }
	        System.out.println("Book with ISBN " + isbn + " not found.");
	    }

	    // Display all books in the library
	    public void displayBooks() {
	        if (books.isEmpty()) {
	            System.out.println("No books available in the library.");
	        } else {
	            System.out.println("Books in the library:");
	            for (Book book : books) {
	                System.out.println(book);
	            }
	        }
	    }
	}


