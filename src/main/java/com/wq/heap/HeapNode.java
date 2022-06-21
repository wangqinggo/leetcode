package com.wq.heap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeapNode {
    private int data;

    public HeapNode(int data) {
        this.data = data;
    }
}
