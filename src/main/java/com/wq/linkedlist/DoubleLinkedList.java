package com.wq.linkedlist;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 双向链表 */
@Data
@NoArgsConstructor
public class DoubleLinkedList<T> {
    private DoubleLinkedListNode<T> head;
    private DoubleLinkedListNode<T> tail;
    int length;

    public boolean isEmpty() {
        return length == 0;
    }

    /** 头插入 */
    public void addFirst(T newData) {
        DoubleLinkedListNode<T> newDoubleLinkedListNode = new DoubleLinkedListNode<>(newData);
        if (isEmpty()) {
            tail = newDoubleLinkedListNode;
        } else {
            head.setPre(newDoubleLinkedListNode);
            newDoubleLinkedListNode.setNext(head);
        }
        head = newDoubleLinkedListNode;
        length++;
    }

    /** 末尾插入 */
    public void addLast(T newData) {
        DoubleLinkedListNode<T> newDoubleLinkedListNode = new DoubleLinkedListNode<>(newData);
        if (isEmpty()) {
            head = newDoubleLinkedListNode;
        } else {
            tail.setNext(newDoubleLinkedListNode);
            newDoubleLinkedListNode.setPre(tail);
        }
        tail = newDoubleLinkedListNode;
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
            DoubleLinkedListNode<T> originHead = head;
            DoubleLinkedListNode<T> newDoubleLinkedListNode = new DoubleLinkedListNode<>(newData);
            for (int i = 0; i < index - 1; i++) {
                head = head.getNext();
            }
            newDoubleLinkedListNode.setNext(head.getNext());
            head.getNext().setPre(newDoubleLinkedListNode);
            head.setNext(newDoubleLinkedListNode);
            newDoubleLinkedListNode.setPre(head);
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
        DoubleLinkedListNode<T> originHead = head;
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
        DoubleLinkedListNode<T> originHead = head;
        for (int i = 0; i < length; i++) {
            if (head != null) {
                if (data.equals(head.getData())) {
                    DoubleLinkedListNode<T> pre = head.getPre();
                    DoubleLinkedListNode<T> next = head.getNext();
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
            DoubleLinkedListNode<T> next = head.getNext();
            next.setPre(null);
            head = next;
            length--;
        }
    }

    /** 删除尾 */
    public void delLast() {
        if (!isEmpty()) {
            DoubleLinkedListNode<T> tailPre = tail.getPre();
            tailPre.setNext(null);
            tail = tailPre;
            length--;
        }
    }

    /** 删除尾并返回 */
    public T pop() {
        DoubleLinkedListNode<T> originTail = tail;
        delLast();
        return originTail.getData();
    }

    /** 找到第k个位置节点，k从0开始 */
    public DoubleLinkedListNode<T> find(int index) {
        DoubleLinkedListNode<T> originHead = head;
        if (index > length - 1) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            head = head.getNext();
        }
        DoubleLinkedListNode<T> data = head;
        head = originHead; // 重置回原始头
        return data;
    }

    public void displayAll() {
        DoubleLinkedListNode<T> originHead = head;
        for (int i = 0; i < length; i++) {
            System.out.println(head.getData());
            head = head.getNext();
        }
        head = originHead;
    }
}
