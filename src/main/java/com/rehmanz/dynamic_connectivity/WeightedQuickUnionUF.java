package com.rehmanz.dynamic_connectivity;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    /**
     * Initialize Weighted union-find with n objects
     *
     * @param n
     * @throws IllegalArgumentException if n < 0
     */
    public WeightedQuickUnionUF(int n) {
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

    // find the root of i and make every other node in path point to it's grandparent (thereby halving path length)
    private int root(int i) {
        validate(i);

        while (i != id[i]) {
            id[i] = id[id[i]];
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
     * Link root of smaller tree to root of larger tree & update the size of the tree
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if(qRoot == pRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }
}
