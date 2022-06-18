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

    /** 指定位置插入 */
    public boolean add(int index, T newData) {
        if (index > length - 1) {
            return false;
        }
        if (length == 0) {
            addFirst(newData);
        } else if (index == length - 1) {
            addLast(newData);
        } else {
            Node<T> originHead = head;
            Node<T> newNode = new Node<>(newData);
            for (int i = 0; i < index - 1; i++) {
                head = head.getNext();
            }
            newNode.setNext(head.getNext());
            head.getNext().setPre(newNode);
            head.setNext(newNode);
            newNode.setPre(head);
            head = originHead;
            length++;
        }
        return true;
    }

    /** 指定位置插入 */
    public void update(T oldData, T newData) {
        if (oldData.equals(newData)) {
            return;
        }
        Node<T> originHead = head;
        if (head != null) {
            for (int i = 0; i < length; i++) {
                if (oldData.equals(head.getData())) {
                    head.setData(newData);
                    head = originHead;
                    return;
                }
                head = head.getNext();
            }
        }
    }

    /** 删除最先指定数据的节点 */
    public void del(T data) {
        Node<T> originHead = head;
        for (int i = 0; i < length; i++) {
            if (head != null) {
                if (data.equals(head.getData())) {
                    Node<T> pre = head.getPre();
                    Node<T> next = head.getNext();
                    pre.setNext(next);
                    if (next != null) {
                        next.setPre(pre);
                    }
                    head = originHead;
                    length--;
                    return;
                }
                head = head.getNext();
            }
        }
    }

    /** 删除头 */
    public void delFirst() {
        if (!isEmpty()) {
            Node<T> next = head.getNext();
            next.setPre(null);
            head = next;
            length--;
        }
    }

    /** 删除尾 */
    public void delLast() {
        if (!isEmpty()) {
            Node<T> tailPre = tail.getPre();
            tailPre.setNext(null);
            tail = tailPre;
            length--;
        }
    }

    /** 删除尾并返回 */
    public T pop() {
        Node<T> originTail = tail;
        delLast();
        return originTail.getData();
    }

    /** 找到第k个位置节点，k从0开始 */
    public Node<T> find(int index) {
        Node<T> originHead = head;
        if (index > length - 1) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            head = head.getNext();
        }
        Node<T> data = head;
        head = originHead; // 重置回原始头
        return data;
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
