package com.wq.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
  private DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

  @BeforeEach
  public void init() {
    doubleLinkedList.setData(1);
    doubleLinkedList.setNext(null);
    doubleLinkedList.setPre(null);
  }

  @Test
  public void testAddLast() {
    Assertions.assertEquals(1, doubleLinkedList.getData());
  }
}
