package p1;

import java.util.Scanner;

// Custom exception for unavailable book
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Custom exception for invalid return
class InvalidReturnException extends Exception {
    public InvalidReturnException(String message) {
        super(message);
    }
}

// Library class
class Library {
    private int availableBooks;

    public Library(int books) {
        if (books < 0) {
            availableBooks = 0;
        } else {
            availableBooks = books;
        }
    }

    // Borrow books
    public void borrowBook(int count) throws BookNotAvailableException {
        if (count > availableBooks) {
            throw new BookNotAvailableException(
                "Requested books are not available."
            );
        }

        availableBooks -= count;
        System.out.println(count + " book(s) borrowed successfully.");
    }

    // Return books
    public void returnBook(int count) throws InvalidReturnException {
        if (count <= 0) {
            throw new InvalidReturnException(
                "Return count must be greater than zero."
            );
        }

        availableBooks += count;
        System.out.println(count + " book(s) returned successfully.");
    }

    // Display books
    public void displayBooks() {
        System.out.println("Available Books: " + availableBooks);
    }
}

// Main class
public class UserDefinedExceptionDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library(10);

        System.out.println("Library Management System");
        System.out.println("------------------------");

        library.displayBooks();

        // Borrow operation
        try {
            System.out.print("Enter number of books to borrow: ");
            int borrow = sc.nextInt();

            library.borrowBook(borrow);

        } catch (BookNotAvailableException e) {
            System.out.println("Borrow Error: " + e.getMessage());
        }

        // Return operation
        try {
            System.out.print("Enter number of books to return: ");
            int returned = sc.nextInt();

            library.returnBook(returned);

        } catch (InvalidReturnException e) {
            System.out.println("Return Error: " + e.getMessage());
        }

        library.displayBooks();

        sc.close();
    }
}