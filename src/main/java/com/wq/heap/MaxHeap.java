package com.wq.heap;

public class MaxHeap extends AHeap {

    public MaxHeap(int maxSize) {
        super(maxSize);
    }

    /** 流上 */
    private void trickleUp() {}

    /** 流下 */
    private void trickleDown() {}

    @Override
    public boolean insert(int key) {
        return false;
    }

    @Override
    public HeapNode remove() {
        return null;
    }
}
