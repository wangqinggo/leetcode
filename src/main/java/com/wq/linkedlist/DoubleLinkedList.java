package com.wq.linkedlist;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 双向链表 */
@Data
@NoArgsConstructor
public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    int length;

    public boolean isEmpty() {
        return length == 0;
    }

    /** 头插入 */
    public void addFirst(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPre(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        length++;
    }

    /** 末尾插入 */
    public void addLast(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPre(tail);
        }
        tail = newNode;
        length++;
    }

    /**
     * 指定位置插入
     *
     * @param data
     * @param index
     */
    public boolean add(int index, T newData) {
        if (index > length - 1) {
            return false;
        }
        Node<T> newNode = new Node<>(newData);
        if (length == 0) {
            addFirst(newData);
        } else if (index == length - 1) {
            addLast(newData);
        } else {
            Node<T> originHead = head;
            for (int i = 0; i < index - 1; i++) {
                head = head.getNext();
            }
            newNode.setNext(head.getNext().getPre());
            head.getNext().setPre(newNode);
            head.setNext(newNode);
            newNode.setPre(head);
            head = originHead;
            length++;
        }
        return true;
    }

    /** 删除最先指定数据的节点 */
    public void del(T data) {

    }

    /** 删除指定位置的节点 */
    public void del(int k) {}

    /** 删除头 */
    public void delFirst() {}

    /** 删除尾 */
    public void delLast() {}

    /** 删除尾并返回 */
    public DoubleLinkedList<T> pop() {
        return null;
    }

    /** 找到第k个位置节点，k从0开始 */
    public Node<T> find(int index) {
        if (index > length - 1) {
            return null;
        }
        for (int i = 0; i < index - 1; i++) {
            head = head.getNext();
        }
        return head;
    }

    public void displayAll() {
        Node<T> originHead = head;
        for (int i = 0; i < length; i++) {
            System.out.println(head.getData());
            head = head.getNext();
        }
        head = originHead;
    }
}
