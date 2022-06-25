package com.wq.trees.btree;

import lombok.Data;

/**
 * @Link <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BTree.java.html">reference</a>
 * @See <a href="https://zh.wikipedia.org/zh-tw/B%E6%A0%91">wiki</a>
 * @See <a href="https://zh.wikipedia.org/zh-tw/File:B-tree.svg">image</a>
 */
@Data
public class BTree<K extends Comparable<K>, V> {
    private Node<K> root;       // root of the B-tree
    private int height;      // height of the B-tree
    private int n;           // number of key-value pairs in the B-tree

    /**
     * Initializes an empty B-tree.
     */
    BTree() {
        root = new Node<>(0);
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    // comparison functions - make Comparable instead of Key to avoid casts
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }
}
