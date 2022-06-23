package com.wq.trees;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BSTTest {

    @Test
    public void testPut() {
        BST<Integer, Integer> bst = new BST<>();
        Assertions.assertEquals(0, bst.getSize());
        bst.put(1, 2);
        Assertions.assertEquals(1, bst.getSize());
        bst.put(1, 2);
        Assertions.assertEquals(1, bst.getSize());
        bst.put(2, 2);
        bst.put(0, 2);
        bst.put(3, 2);
        Assertions.assertEquals(4, bst.getSize());
    }
}
