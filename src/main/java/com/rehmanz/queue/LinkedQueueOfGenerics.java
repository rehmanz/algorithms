package com.rehmanz.queue;

public class LinkedQueueOfGenerics<Item> {
    private Node first, last;

    private class Node {
        Item item;
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
    public void enqueue(Item item) {
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
    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
