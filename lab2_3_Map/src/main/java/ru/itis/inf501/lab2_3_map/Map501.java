package ru.itis.inf501.lab2_3_map;

public interface Map501<K, V> {
    int size();
    void put(K key, V value);
    V get(K key);
    Set501<K> getKeySet();
    List501<V> getValues();
    List501<Entry501<K,V>> getEntries();

}
