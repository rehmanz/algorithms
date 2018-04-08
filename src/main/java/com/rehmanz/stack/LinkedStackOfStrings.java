package com.rehmanz.stack;

public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    /**
     * Check if stack is emptry
     *
     * @return True if empty, False otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Push an item on the stack
     *
     * @param item
     */
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    /**
     * Pop the item from the stack
     *
     * @return item
     */
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}
