package com.wq.stack;

import lombok.Data;

@Data
public class StackBasedOnLinkedList<T> {
    private Node<T> top;

    /** 入栈 */
    public void push(T data) {
        if (data != null) {
            Node<T> tNode = new Node<>(data);
            tNode.setNext(top);
            top = tNode;
        }
    }

    /** 出栈 */
    public Node<T> pop() {
        if (top != null) {
            Node<T> next = top.getNext();
            Node<T> tNode = top;
            top = next;
            return tNode;
        }
        return null;
    }

    public void displayAll() {
        while (top != null) {
            System.out.println(top.getData());
            top = top.getNext();
        }
    }
}
