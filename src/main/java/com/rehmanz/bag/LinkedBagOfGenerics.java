package com.rehmanz.bag;

import java.util.Iterator;

public class LinkedBagOfGenerics<Item> implements Iterable<Item> {
    private Node first = null;
    private int size = 0;

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
     * Size of the bag
     *
     * @return Size of the bag
     */
    public int size() {
        return size;
    }

    /**
     * Add an item onto bag
     *
     * @param item
     */
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
}
