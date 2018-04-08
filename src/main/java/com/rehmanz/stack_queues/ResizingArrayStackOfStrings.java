package com.rehmanz.stack_queues;

public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i=0; i < N; i++) {
            copy[i] = s[1];
        }
        s = copy;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

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
