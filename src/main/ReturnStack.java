package src.main;

import java.util.ArrayList;
import java.util.List;

public class ReturnStack {
    private List<Book> borrowStack = new ArrayList<>();
    public int top = -1;

    public void push(Book book) {
        top++;
        borrowStack.add(book);
    }

    public Book pop() {
        if (top == -1) {
            return null;
        }
        Book poppedBook = borrowStack.remove(top);
        top--;
        return poppedBook;
    }
}