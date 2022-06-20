package com.wq.heap;

public interface Heap {
    /*
     * Checks if the heap is empty
     * */
    boolean isEmpty();

    /*
     * Inserts a node into the heap
     * */
    boolean insert(int key);

    /*
     * Removes the root of the heap.
     * */
    HeapNode remove();

    /*
     * Different from remove. It doesn't remove the root node just returns its value.
     * */
    HeapNode peek();

    /*
     * Displays the heap
     * */
    void displayHeap();
}
