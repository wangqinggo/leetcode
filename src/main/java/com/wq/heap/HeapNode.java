package com.wq.heap;

import lombok.Data;

@Data
public class HeapNode {
    private int data;

    public HeapNode(int data) {
        this.data = data;
    }
}
