package com.rehmanz.stack;

import java.util.Iterator;

public class LinkedStackOfGenerics<Item> implements Iterable<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove() { /* not supported */ }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Iterator
     *
     * @return Iterator object
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
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
    public void push(Item item) {
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
    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
}
