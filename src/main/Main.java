package src.main;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book(1, "1111111", "Book_1", 10.99, "Author_1", 2020);
        Book book2 = new Book(2, "2222222", "Book_2", 10.99, "Author_2", 2021);
        Book book3 = new Book(3, "3333333", "Book_3", 10.99, "Author_3", 2022);
        Book book4 = new Book(4, "4444444", "Book_4", 10.99, "Author_4", 2023);
        Book book5 = new Book(5, "5555555", "Book_5", 10.99, "Author_1", 1900);
        Book book6 = new Book(6, "6666666", "Book_6", 10.99, "Author_2", 1950);
        Book book7 = new Book(7, "7777777", "Book_7", 10.99, "Author_1", 2000);

        //add book
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        //add book to favourites
        library.addBookToFavourites(book1);
        library.addBookToFavourites(book2);

        //display list of books
        library.displayBooks();

        //display list of fav books
        library.displayFavourites();

        //find book by id
        int bookIdToFind = 2;
        Book foundBook = library.findBookByID(bookIdToFind);
        if (foundBook != null) {
            System.out.println("\nFound Book by ID " + bookIdToFind + ": " + foundBook);
        } else {
            System.out.println("\nBook with ID " + bookIdToFind + " not found.");
        }

        //remove book from library and favourite list
        library.removeBook(book3);
        library.removeBookFromFavourites(book3);

        //display after removing
        library.displayBooks();
        library.displayFavourites();

        //streams - f to i
        String authorWithMostBooks = library.findAuthorWithMostBooks();
        System.out.println("Author with the most books in the list: " + authorWithMostBooks);

        //queue
        BorrowQueue borrowQueue = new BorrowQueue();

        borrowQueue.enqueue(book1);
        borrowQueue.enqueue(book2);
        borrowQueue.enqueue(book3);
        borrowQueue.enqueue(book4);

        borrowQueue.displayBorrowQueue();

        borrowQueue.dequeue();
        borrowQueue.dequeue();

        borrowQueue.displayBorrowQueue();

        borrowQueue.peekBorrowQueue();
    }
}
