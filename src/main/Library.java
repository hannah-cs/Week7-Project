package src.main;
import java.util.HashSet;

public class Library {
    private HashSet<Book> books;
    private HashSet<Member> members;

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
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

    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void removeMember(Member member){
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

    }

}
