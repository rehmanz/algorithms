package com.rehmanz.stack;

import java.util.Iterator;

public class ResizingArrayStackOfGenerics<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public ResizingArrayStackOfGenerics() {
        s = (Item[]) new Object[1];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i=0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public class ListIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() { return i > 0; }
        public void remove() { /* not supported */ }
        public Item next() { return s[--i]; }
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
        return N == 0;
    }

    /**
     * Push an item on the stack
     *
     * @param item
     */
    public void push(Item item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    /**
     * Pop the item from the stack
     *
     * @return item
     */
    public Item pop() {
        Item item = s[--N];
        s[N] = null;

        // when array is quarter full, resize it to half
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }

        return item;
    }
}
