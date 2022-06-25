package com.wq.trees.bst;

import lombok.Data;

@Data
public class Node<K, V> {
    private K k;           // sorted by key
    private V v;         // associated data
    private Node<K,V> left, right;  // left and right subtrees
    private int size;

    public Node(K k, V v, int size) {
        this.k = k;
        this.v = v;
        this.size = size;
    }
}
