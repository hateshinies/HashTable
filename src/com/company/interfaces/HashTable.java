package com.company.interfaces;

public interface HashTable<K, V> {
    void put(K key, V value);

    void remove(K key);

    V get(K key);
}
