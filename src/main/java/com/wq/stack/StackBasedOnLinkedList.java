package com.wq.stack;

import lombok.Data;

@Data
public class StackBasedOnLinkedList<T> {
    private StackNode<T> top;

    /** 入栈 */
    public void push(T data) {
        if (data != null) {
            StackNode<T> tStackNode = new StackNode<>(data);
            tStackNode.setNext(top);
            top = tStackNode;
        }
    }

    /** 出栈 */
    public StackNode<T> pop() {
        if (top != null) {
            StackNode<T> next = top.getNext();
            StackNode<T> tStackNode = top;
            top = next;
            return tStackNode;
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
