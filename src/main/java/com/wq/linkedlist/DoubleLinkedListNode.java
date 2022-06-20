package com.wq.linkedlist;

import lombok.Data;

@Data
public class DoubleLinkedListNode<T> {
    private T data;
    private DoubleLinkedListNode<T> pre;
    private DoubleLinkedListNode<T> next;

    DoubleLinkedListNode(T data) {
        this.data = data;
    }
}
