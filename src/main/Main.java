package src.main;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book(1, "1111111", "Book_1",10.99,"Author_1", 2020);
        Book book2 = new Book(2, "2222222", "Book_2",10.99, "Author_2", 2021);
        Book book3 = new Book(3, "3333333", "Book_3",10.99, "Author_3", 2022);
        Book book4 = new Book(4, "4444444", "Book_4",10.99, "Author_4", 2023);

        //add book
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

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

        //queue tasks
        System.out.println("Queue tasks:");
        BorrowQueue borrowQueue = new BorrowQueue();
        borrowQueue.enqueue(book1);
        borrowQueue.enqueue(book3);
        borrowQueue.enqueue(book4);
        borrowQueue.displayBorrowQueue();
        borrowQueue.peekBorrowQueue();
        borrowQueue.dequeue();
        borrowQueue.displayBorrowQueue();
    }
}
