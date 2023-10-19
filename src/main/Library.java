package src.main;

import java.util.*;
import java.util.stream.*;

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

    public HashSet<Book> getBooks() {
        return books;
    }

    public Book findBookByID(int id) {
        for (Book book : books) {
            if (book.getId() == (id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBooksByTitleOrAuthor(String query) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query))
                .collect(Collectors.toList());
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

    public List<Member> sortMembersByName() {
        return members.stream()
                .sorted(Comparator.comparing(Member::getName))
                .collect(Collectors.toList());
    }

    //    f. Find the author with the most books in the list.
    public String findAuthorWithMostBooks() {
        Map<String, Long> authorBookCounts = books.stream()
                .filter(book -> book.getAuthor() != null) // Filter out books with null authors
                .map(Book::getAuthor)
                .collect(Collectors.groupingBy(author -> author, Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEntry = authorBookCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return maxEntry.map(Map.Entry::getKey).orElse("No authors found");
    }
}