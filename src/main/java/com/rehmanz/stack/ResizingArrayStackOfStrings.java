package com.rehmanz.stack;

public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i=0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
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
    public void push(String item) {
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
    public String pop() {
        String item = s[--N];
        s[N] = null;

        // when array is quarter full, resize it to half
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }

        return item;
    }
}
