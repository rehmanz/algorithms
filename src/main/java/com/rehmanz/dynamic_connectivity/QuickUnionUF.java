package com.rehmanz.dynamic_connectivity;

public class QuickUnionUF {
    private int[] id;

    /**
     * Initialize union-find with n objects
     *
     * @param n
     * @throws IllegalArgumentException if n < 0
     */
    public QuickUnionUF(int n) {
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private void validate(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (id.length - 1));
        }
    }

    // find the root of i
    private int root(int i) {
        validate(i);

        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    /**
     * Check if p and q are in the same component
     *
     * @param p
     * @param q
     * @return True if p and q are in the same component, False otherwise
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /***
     * Change root of p to point to root of q
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        id[pRoot] = qRoot;
    }
}
