package com.wq.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MaxHeapTest")
public class MaxHeapTest {

    private final MaxHeap maxHeap = new MaxHeap(10);

    @BeforeEach
    public void init() {
        maxHeap.insert(1);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(3);
        maxHeap.insert(5);
        maxHeap.displayHeap();
        System.out.println("===init end====");
    }

    @Test
    public void testInsert() {
        maxHeap.insert(2);
        Assertions.assertEquals(6, maxHeap.getCurrentSize());
    }

    @Test
    public void testRemove() {
        maxHeap.remove();
        Assertions.assertEquals(4, maxHeap.getCurrentSize());
        maxHeap.remove();
        Assertions.assertEquals(3, maxHeap.getCurrentSize());
    }
}
