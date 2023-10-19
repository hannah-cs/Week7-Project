package src.main;

import java.util.*;

public class BorrowQueue {
    LinkedList<Book> borrowQueue = new LinkedList<>();
    private int queueLength = 5;
    int front = -1;
    int back = -1;

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return back == queueLength - 1;
    }

    public void enqueue(Book book) {
        if (isFull()) {
            System.out.println("The queue is full. Could not add " + book.getTitle());
        } else {
            if (isEmpty()) {
                front = 0;
            }
            back++;
            borrowQueue.add(book);
            System.out.println("Added " + book.getTitle() + " to borrow queue. Queue contents: " + borrowQueue.toString());
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            Book dequeuedItem = borrowQueue.get(front);
            borrowQueue.remove(front);
            back--;
            if (front == back) {
                front = -1;
                back = -1;
            } else {
                front = (front + 1);
            }
            System.out.println("Removed " + dequeuedItem.getTitle() + ". Queue contents: " + borrowQueue.toString());
        }
    }

    public void displayBorrowQueue() {
        System.out.println("Queue contents: " + borrowQueue.toString());
    }

    public void peekBorrowQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("The first item in the queue is " + borrowQueue.get(front).getTitle());
        }
    }
}