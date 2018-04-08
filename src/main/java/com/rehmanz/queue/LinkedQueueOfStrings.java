package com.rehmanz.queue;

public class LinkedQueueOfStrings {
    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    /**
     * Check if queue is emptry
     *
     * @return True if empty, False otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Enqueue an item
     *
     * @param item
     */
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    /**
     * Dequeue an item
     *
     * @return item
     */
    public String dequeue() {
        String item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
