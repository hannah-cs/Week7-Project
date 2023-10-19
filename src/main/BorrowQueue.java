package src.main;

import java.util.LinkedList;

public class BorrowQueue {
    private LinkedList<Book> borrowQueue = new LinkedList<>();
    private int queueMaxLength = 5;  // Maximum queue length

    public boolean isEmpty() {
        return borrowQueue.isEmpty();
    }

    public boolean isFull() {
        return borrowQueue.size() >= queueMaxLength;
    }

    public void enqueue(Book book) {
        if (isFull()) {
            System.out.println("The queue is full. Could not add " + book.getTitle());
        } else {
            borrowQueue.addLast(book);
            System.out.println("Added " + book.getTitle() + " to borrow queue. Queue contents: " + borrowQueue);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            Book dequeuedItem = borrowQueue.pollFirst();
            System.out.println("Removed " + dequeuedItem.getTitle() + ". Queue contents: " + borrowQueue);
        }
    }

    public void displayBorrowQueue() {
        System.out.println("Queue contents: " + borrowQueue);
    }

    public void peekBorrowQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("The first item in the queue is " + borrowQueue.getFirst().getTitle());
        }
    }
}
