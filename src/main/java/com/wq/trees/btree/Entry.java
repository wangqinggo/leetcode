package com.wq.trees.btree;

import lombok.Data;

/**
 * internal nodes: only use key and next
 * external nodes: only use key and value
 */
@Data
public class Entry<T> {
    private Comparable<T> key;
    private Object val;
    private Node<T> next;     // helper field to iterate over array entries

    public Entry(Comparable<T> key, Object val, Node<T> next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
