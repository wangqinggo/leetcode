package com.wq.heap;

public class MaxHeap extends AHeap {

    public MaxHeap(int maxSize) {
        super(maxSize);
    }

    /** 流上 */
    private void trickleUp(int index) {
        int parentIndex = (index - 1) / 2;
        HeapNode bottom = heapArray[index];
        while (index > 0 && bottom.getData() > heapArray[parentIndex].getData()) {
            // move smaller parent downwards.
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    /** 流下 */
    private void trickleDown(int index) {
        int currentSize = getCurrentSize();
        int largerChildIndex;
        HeapNode top = heapArray[0];
        // while node has atleast one child.
        while (index < currentSize / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            // find the larger child of the left and right child.
            if (rightChildIndex < currentSize
                    && heapArray[rightChildIndex].getData() > heapArray[leftChildIndex].getData()) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }
            // if parent is greater than the larger child then break.
            if (top.getData() > heapArray[largerChildIndex].getData()) {
                break;
            }
            // shift larger child up
            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex;
        }
        heapArray[index] = top;
    }

    @Override
    public boolean insert(int key) {
        int currentSize = getCurrentSize();
        int maxSize = getMaxSize();
        if (currentSize == maxSize) {
            return false;
        }
        HeapNode node = new HeapNode(key);
        heapArray[currentSize] = node;
        trickleUp(currentSize);
        setCurrentSize(currentSize + 1);
        return true;
    }

    @Override
    public HeapNode remove() {
        int currentSize = getCurrentSize();
        HeapNode root = null;
        if (heapArray.length > 0) {
            root = heapArray[0];
            heapArray[0] = heapArray[currentSize - 1];
            trickleDown(0);
            setCurrentSize(currentSize - 1);
        }
        System.out.println("Removing the root---------" + root);
        return root;
    }
}
