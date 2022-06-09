package com.wq.linkedlist;

import lombok.Data;
import lombok.NoArgsConstructor;

/** 双向链表 */
@Data
@NoArgsConstructor
public class DoubleLinkedList<T> {
    T data;
    DoubleLinkedList<T> pre;
    DoubleLinkedList<T> next;

    DoubleLinkedList(T data) {
        this.data = data;
    }

    /** 末尾插入 */
    public void addLast(T newData) {
        DoubleLinkedList<T> newNode = new DoubleLinkedList<>(newData);
        if (pre == null && data == null && next == null) {
            data = newNode.getData();
        } else {
            DoubleLinkedList<T> tmp = this;
            while (tmp != null && tmp.getNext() != null) {
                tmp = tmp.next;
            }
            newNode.setPre(tmp);
            if (tmp != null) {
                tmp.next = newNode;
            }
        }
    }

    /**
     * 指定位置插入
     *
     * @param data
     * @param index
     */
    public void add(T data, DoubleLinkedList<T> index) {}

    /** 删除指定数据的节点 */
    public void del(T data) {}

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
    public DoubleLinkedList<T> find(int k) {

        return null;
    }
}
