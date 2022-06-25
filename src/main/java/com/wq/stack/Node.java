package com.wq.stack;

import lombok.Data;

@Data
public class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
    }
}
