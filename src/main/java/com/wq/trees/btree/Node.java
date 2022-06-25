package com.wq.trees.btree;

import lombok.Data;

/**
 * BTree Node
 */
@Data
public class Node <T>{
    // max children per B-tree node = M-1
    // (must be even and greater than 2)
    private static final int M = 4;
    private int m;                             // number of children
    private Entry<T>[] children = new Entry[M];   // the array of children

    // create a node with k children
    Node(int k) {
        m = k;
    }
}
