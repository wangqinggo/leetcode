package com.wq.heap;

import lombok.Data;

@Data
public abstract class AHeap implements Heap {
    HeapNode[] heapArray;

    private int maxSize;

    private int currentSize;

    AHeap(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.heapArray = new HeapNode[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return getCurrentSize() == 0;
    }

    @Override
    public abstract boolean insert(int key);

    @Override
    public abstract HeapNode remove();

    @Override
    public HeapNode peek() {
        if (isEmpty()) {
            return null;
        } else {
            return heapArray[0];
        }
    }

    @Override
    public void displayHeap() {
        System.out.print("heapArray: ");
        for (HeapNode heapNode : this.heapArray) {
            if (heapNode != null) {
                System.out.print(heapNode.getData() + " ");
            }
        }
        System.out.println();
    }
}
