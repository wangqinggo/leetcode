package com.wq.hashmap;


public interface CustomHashMap<K, V> {

    void put(K key, V value);

    V get(K key);

    boolean remove(K key);
}
