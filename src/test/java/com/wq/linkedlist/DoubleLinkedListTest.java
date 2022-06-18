package com.wq.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DoubleLinkedListTest")
public class DoubleLinkedListTest {
    private final DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

    @BeforeEach
    public void init() {
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.displayAll();
        System.out.println("===init end====");
    }

    @Test
    public void testAddFirst() {
        doubleLinkedList.addFirst(0);
        Assertions.assertEquals(0, doubleLinkedList.getHead().getData());
        doubleLinkedList.displayAll();
    }

    @Test
    public void testAddLast() {
        Assertions.assertEquals(3, doubleLinkedList.getLength());
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(5);
        Assertions.assertEquals(1, doubleLinkedList.getHead().getData());
        Assertions.assertEquals(5, doubleLinkedList.getTail().getData());
    }

    @Test
    public void testAdd() {
        doubleLinkedList.add(1, 33);
        doubleLinkedList.displayAll();
        Assertions.assertEquals(33, doubleLinkedList.find(1).getData());
    }

    @Test
    public void testDel() {
        doubleLinkedList.del(3);
        doubleLinkedList.displayAll();
        Assertions.assertEquals(2, doubleLinkedList.find(1).getData());
    }

    @Test
    public void testDelFirst() {
        doubleLinkedList.delFirst();
        Assertions.assertEquals(2, doubleLinkedList.find(0).getData());
        doubleLinkedList.displayAll();
    }

    @Test
    public void testDelLast() {
        doubleLinkedList.delLast();
        Assertions.assertEquals(2, doubleLinkedList.find(1).getData());
        doubleLinkedList.displayAll();
    }

    @Test
    public void testPop() {
        Assertions.assertEquals(3, doubleLinkedList.pop());
        doubleLinkedList.displayAll();
    }

    @Test
    public void testUpdate() {
        doubleLinkedList.update(3, 333);
        Assertions.assertEquals(333, doubleLinkedList.find(2).getData());
        doubleLinkedList.displayAll();
    }
}
