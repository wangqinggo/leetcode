package com.wq.trees;

import lombok.Data;

@Data
public class TreeNode<K, V> {
    private K k;           // sorted by key
    private V v;         // associated data
    private TreeNode<K,V> left, right;  // left and right subtrees
    private int size;

    public TreeNode(K k, V v, int size) {
        this.k = k;
        this.v = v;
        this.size = size;
    }
}
