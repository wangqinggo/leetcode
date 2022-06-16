package com.wq.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    private final DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

    @BeforeEach
    public void init() {
       doubleLinkedList.addLast(1);
       doubleLinkedList.addLast(2);
       doubleLinkedList.addLast(3);
    }

    @Test
    public void testAddLast() {
        Assertions.assertEquals(3, doubleLinkedList.getLength());
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        Assertions.assertEquals(1,doubleLinkedList.getHead().getData());
        Assertions.assertEquals(5,doubleLinkedList.getTail().getData());
        doubleLinkedList.addFirst(0);
        Assertions.assertEquals(0,doubleLinkedList.getHead().getData());
        doubleLinkedList.add(3, 33);
        doubleLinkedList.displayAll();
        Assertions.assertEquals(33,doubleLinkedList.find(4).getData());
    }
}
