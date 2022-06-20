package com.wq.stack;

import lombok.Data;

@Data
public class StackNode<T> {
    private T data;
    private StackNode<T> next;

    StackNode(T data) {
        this.data = data;
    }
}
