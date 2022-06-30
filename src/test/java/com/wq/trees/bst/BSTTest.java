package com.wq.trees.bst;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BSTTest")
public class BSTTest {
    private final BST<Integer, Integer> bst = new BST<>();

    @BeforeEach
    public void init() {
        Assertions.assertEquals(0, bst.getSize());
        bst.put(1, 2);
        Assertions.assertEquals(1, bst.getSize());
        bst.put(1, 2);
        Assertions.assertEquals(1, bst.getSize());
        bst.put(2, 2);
        bst.put(0, 2);
    }

    @Test
    public void testPut() {
        bst.put(3, 2);
        Assertions.assertEquals(4, bst.getSize());
    }

    @Test
    public void testGet() {
        bst.put(3, 2);
        Assertions.assertEquals(2, bst.get(3));
        bst.delete(3);
        Assertions.assertNull(bst.get(3));
    }

    @Test
    public void testDelMin() {
        bst.put(3, 2);
        bst.deleteMin();
        Assertions.assertEquals(3, bst.getSize());
    }

    @Test
    public void testDelMax() {
        bst.put(3, 2);
        bst.deleteMax();
        Assertions.assertEquals(3, bst.getSize());
    }

    @Test
    public void testDel() {
        bst.put(3, 2);
        bst.put(4, 2);
        bst.delete(3);
        Assertions.assertEquals(4, bst.getSize());
        bst.delete(1);
        Assertions.assertEquals(3, bst.getSize());
    }

    @Test
    public void preOrderTraverseRecursion() {
        bst.put(3, 2);
        bst.put(-1, 2);
        bst.preOrderTraverseRecursion();
        System.out.println();
        bst.preOrderTraverseUnRecursion();
    }

    @Test
    public void midOrderTraverseRecursion() {
        bst.put(3, 2);
        bst.put(-1, 2);
        bst.midOrderTraverseRecursion();
        // todo
    }

    @Test
    public void postOrderTraverseRecursion() {
        bst.put(3, 2);
        bst.put(-1, 2);
        bst.postOrderTraverseRecursion();
        //  todo
    }

    @Test
    public void levelOrderTraverseRecursion() {
        bst.put(3, 2);
        bst.put(-1, 2);
        bst.levelOrderTraverseRecursion();
        //  todo
    }
}
