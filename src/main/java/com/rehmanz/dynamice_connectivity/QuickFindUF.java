package com.rehmanz.dynamice_connectivity;

public class QuickFindUF {
    private int[] id;

    /**
     * Initialize union-find with n objects
     *
     * @param n
     * @throws IllegalArgumentException if n < 0
     */
    public QuickFindUF(int n) {
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

    /**
     * Check if p and q are in the same component
     *
     * @param p
     * @param q
     * @return True if p and q are in the same component, False otherwise
     */
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);

        return id[p] == id[q];
    }

    /**
     * Change all entries with id[p] to id[q]
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int p_id = id[p];
        int q_id = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == p_id) {
                id[i] = q_id;
            }
        }
    }

}
