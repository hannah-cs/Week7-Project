package src.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Library {

    private HashSet<Book> books = new HashSet<>();
    private HashSet<Book> favouriteBooks = new HashSet<>();
    private HashSet<Member> members = new HashSet<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public boolean updateBook(Book oldBook, Book newBook) {
        if (books.contains(oldBook)) {
            oldBook = newBook;
            return true;
        } else {
            return false;
        }
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByID(int id) {
        for (Book book : books) {
            if (book.getId() == (id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public void addBookToFavourites(Book book) {
        favouriteBooks.add(book);
    }

    public void removeBookFromFavourites(Book book) {
        favouriteBooks.remove(book);
    }


    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public boolean updateMember(Member oldMember, Member newMember) {
        if (members.contains(oldMember)) {
            oldMember = newMember;
            return true;
        } else {
            return false;
        }
    }

    public Member findMember(String memberName) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("All books:");
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getBookInfo());
        }
    }

    public void displayFavourites() {
        System.out.println("Favourite books:");
        Iterator<Book> iterator = favouriteBooks.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getBookInfo());
        }
    }
}