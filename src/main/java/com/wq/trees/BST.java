package com.wq.trees;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

/**
 * @Link <a href="https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BST.java.html">.reference..</a>
 */
@Data
@NoArgsConstructor
public class BST<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    private int size(TreeNode<K, V> tn) {
        if (tn == null) {
            return 0;
        } else {
            return tn.getSize();
        }
    }

    public int getSize() {
        return size(root);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    private TreeNode<K, V> put(TreeNode<K, V> tn, K k, V v) {
        if (k == null) {
            throw new IllegalArgumentException("key is null.");
        }

        if (v == null) {
            delete(k);
            return null;
        }

        if (tn == null) {
            return new TreeNode<>(k, v, 1);
        }

        int cmp = k.compareTo(tn.getK());
        if (cmp < 0) {
            TreeNode<K, V> left = tn.getLeft();
            tn.setLeft(put(left, k, v));
        } else if (cmp > 0) {
            TreeNode<K, V> right = tn.getRight();
            tn.setRight(put(right, k, v));
        } else {
            tn.setV(v);
        }
        tn.setSize(size(tn.getLeft()) + size(tn.getRight()) + 1);
        return tn;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param k the key
     * @param v the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(K k, V v) {
        root = put(root, k, v);
    }

    /**
     * Removes the smallest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private TreeNode<K,V> deleteMin(TreeNode<K,V> x) {
        if (x.getLeft() == null) return x.getRight();// delete self
        x.setLeft(deleteMin(x.getLeft()));
        x.setSize(size(x.getLeft()) + size(x.getRight()) + 1);
        return x;
    }

    private TreeNode<K, V> delete(TreeNode<K, V> tn, K k) {
        if (tn == null) {
            return null;
        }
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param k the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    private void delete(K k) {
        if (k == null) {
            throw new IllegalArgumentException("key is null.");
        }
        root = delete(root, k);
    }

}
