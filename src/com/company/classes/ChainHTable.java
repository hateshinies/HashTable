package com.company.classes;

import com.company.interfaces.HashTable;

import java.util.LinkedList;
import java.util.List;

public class ChainHTable<K, V> implements HashTable<K, V> {
    private class Entry<K, V> {
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>> table[];


    @SuppressWarnings("unchecked")
    public ChainHTable() {
        table = new LinkedList[5];
        for (int i = 0; i < 5; i++) {
            table[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int index = key.hashCode() % table.length;
        List<Entry<K, V>> list = table[index];
        if (!list.isEmpty()) {                          //если лист не пустой, то что-то уже лежит
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)) {            //если key=key, то дубликат ключа
                    entry.value = value;
                    System.out.println("Заменяю value");
                    return;
                }
                System.out.println("Ага! Коллизия!");   //если нет, коллизия

            }
        }
        list.add(new Entry<>(key, value));
    }

    @Override
    public void remove(K key) {
        int index = key.hashCode() % table.length;
        List<Entry<K, V>> list = table[index];
        if (list.isEmpty()) {
            System.out.println("Error: key doesnt exist");
            return;
        }
        for (Entry<K, V> aList : list) {
            if (aList.key.equals(key)) {
                list.remove(aList);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = key.hashCode() % table.length;
        List<Entry<K, V>> list = table[index];
        if (list.isEmpty()) {
            System.out.println("Error: key doesnt exist");
            return null;
        }
        for (Entry<K, V> aList : list) {
            if (aList.key.equals(key)) {
                return aList.value;
            }
        }
        return null;
    }
}






































