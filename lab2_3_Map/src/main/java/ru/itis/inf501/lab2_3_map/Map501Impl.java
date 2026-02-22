package ru.itis.inf501.lab2_3_map;

public class Map501Impl<K,V> implements Map501<K,V> {

    private int size = 0;
    private Entry501<K, V>[] entries = new Entry501[5];

    private class Entry501Impl<K, V> implements Entry501<K,V> {
        K key;
        V value;

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public String toString() {
            return key.toString() + " : " + value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        Entry501Impl entry = new Entry501Impl();
        entry.key = key;
        entry.value = value;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i] = entry;
                flag = true;
            }
        }
        if (flag == false) {
            entries[size++] = entry;
        }
//        if (k == 0) {
//            entries[size++] = entry;
//        } else {
//            entries[k] = entry;
//        }

//        int res = (int) key;
//        entries[res] = entry;
//        size++;

    }

    @Override
    public V get(K key) {
        V result = null;
        for(int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].getKey() == key) {
                result = entries[i].getValue();
            }
        }
        return result;
    }

    @Override
    public Set501<K> getKeySet() {
        Set501<K> set = new Set501Implements<>();
        for(int i = 0; i < size; i++) {
            if (entries[i] != null) {
                set.add(entries[i].getKey());
            }
        }
        return set;
    }

    @Override
    public List501<V> getValues() {
        List501<V> list = new List501Implements<>();
        for(int i = 0; i < size; i++) {
            if (entries[i] != null) {
                list.add(entries[i].getValue());
            }
        }
        return list;
        //list.add(entries[i].getKey());
    }

    @Override
    public List501<Entry501<K, V>> getEntries() {
        List501<Entry501<K, V>> list = new List501Implements<>();
        for(int i = 0; i < size; i++) {
            list.add(entries[i]);
        }
        return list;
    }
}
