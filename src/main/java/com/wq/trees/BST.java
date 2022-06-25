package com.wq.trees;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
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
        if (k == null) throw new IllegalArgumentException("key is null.");

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

    public V get(K k) {
        return get(root, k);
    }

    private V get(TreeNode<K, V> tn, K k) {
        if (k == null) throw new IllegalArgumentException("key is null.");
        if (tn == null) return null;
        int cmp = k.compareTo(tn.getK());
        if (cmp < 0) {
            return get(tn.getLeft(), k);
        } else if (cmp > 0) {
            return get(tn.getRight(), k);
        } else {
            return tn.getV();
        }
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

    /**
     * delete max ,set left
     */
    private TreeNode<K, V> deleteMin(TreeNode<K, V> x) {
        if (x.getLeft() == null) return x.getRight();// delete self
        x.setLeft(deleteMin(x.getLeft()));
        x.setSize(size(x.getLeft()) + size(x.getRight()) + 1);
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    /**
     * delete max ,set right
     */
    private TreeNode<K, V> deleteMax(TreeNode<K, V> x) {
        if (x.getRight() == null) return x.getLeft();// delete self
        x.setRight(deleteMax(x.getRight()));
        x.setSize(size(x.getLeft()) + size(x.getRight()) + 1);
        return x;
    }

    private TreeNode<K, V> delete(TreeNode<K, V> tn, K k) {
        if (tn == null) {
            return null;
        } else {
            int cmp = k.compareTo(tn.getK());
            if (cmp < 0) {
                tn.setLeft(delete(tn.getLeft(), k));
            } else if (cmp > 0) {
                tn.setRight(delete(tn.getRight(), k));
            } else {
                if (tn.getRight() == null) return tn.getLeft();
                if (tn.getLeft() == null) return tn.getRight();
                TreeNode<K, V> t = tn;
                tn = min(t.getRight());
                tn.setRight(deleteMin(t.getRight()));
                tn.setLeft(t.getLeft());
            }
            tn.setSize(size(tn.getRight()) + size(tn.getLeft()) + 1);
            return tn;
        }
    }


    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param k the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(K k) {
        if (k == null) {
            throw new IllegalArgumentException("key is null.");
        }
        root = delete(root, k);
    }

    private TreeNode<K, V> min(TreeNode<K, V> tn) {
        if (tn.getLeft() == null) return tn;
        else return min(tn.getLeft());
    }

    /**
     * root->left->right
     */
    public void preOrderTraverseRecursion() {
        preOrderTraverseRecursion(root);
    }

    private void preOrderTraverseRecursion(TreeNode<K, V> tn) {
        if (tn != null) {
            System.out.print("k:" + tn.getK() + ",v:" + tn.getV() + "  ");
            preOrderTraverseRecursion(tn.getLeft());
            preOrderTraverseRecursion(tn.getRight());
        }
    }

    public void preOrderTraverseUnRecursion() {
        preOrderTraverseUnRecursion(root);
    }

    private void preOrderTraverseUnRecursion(TreeNode<K, V> tn) {
        LinkedList<TreeNode<K, V>> stack = new LinkedList<>();
        TreeNode<K, V> n = tn;
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                System.out.print("k:" + n.getK() + ",v:" + n.getV() + "  ");
                stack.push(n);
                n = n.getLeft();
            } else {
                TreeNode<K, V> t = stack.pop();
                n = t.getRight();
            }
        }
    }

    /**
     * left->root->right
     */
    public void midOrderTraverseRecursion() {
        midOrderTraverseRecursion(root);
    }

    private void midOrderTraverseRecursion(TreeNode<K, V> tn) {
        if (tn != null) {
            midOrderTraverseRecursion(tn.getLeft());
            System.out.print("k:" + tn.getK() + ",v:" + tn.getV() + "  ");
            midOrderTraverseRecursion(tn.getRight());
        }
    }

    /**
     * right-> left->root
     */
    public void postOrderTraverseRecursion() {
        postOrderTraverseRecursion(root);
    }

    private void postOrderTraverseRecursion(TreeNode<K, V> tn) {
        if (tn != null) {
            postOrderTraverseRecursion(tn.getRight());
            postOrderTraverseRecursion(tn.getLeft());
            System.out.print("k:" + tn.getK() + ",v:" + tn.getV() + "  ");
        }
    }

    /**
     * top->bottom
     */
    public void levelOrderTraverseRecursion() {
        levelOrderTraverseRecursion(root);
    }

    private void levelOrderTraverseRecursion(TreeNode<K, V> tn) {
        if (tn != null) {
            LinkedList<TreeNode<K, V>> queue = new LinkedList<>();
            queue.offer(tn);
            while (!queue.isEmpty()) {
                TreeNode<K, V> n = queue.poll();
                System.out.print("k:" + n.getK() + ",v:" + n.getV() + "  ");
                if (n.getLeft() != null) {
                    queue.offer(n.getLeft());
                }
                if (n.getRight() != null) {
                    queue.offer(n.getRight());
                }
            }
        }
    }
}
