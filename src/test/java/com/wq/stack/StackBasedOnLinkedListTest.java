package com.wq.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("StackBasedOnLinkedListTest")
public class StackBasedOnLinkedListTest {
    private final StackBasedOnLinkedList<Integer> stack = new StackBasedOnLinkedList<>();

    @BeforeEach
    public void init() {
        stack.push(1);
        stack.push(2);
        stack.displayAll();
        System.out.println("===init end====");
    }

    @Test
    public void testPush() {
        stack.push(3);
        Assertions.assertEquals(3, stack.pop().getData());
        stack.displayAll();
    }
}
