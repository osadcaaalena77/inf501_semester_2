package ru.itis.inf501.lab2_3_map;
/*
    Дженерики вух типов K - для ключа, V - для значения
    Дженерик - псевдопеременная, задающая тип данных
 */
public interface Entry501<K, V> {
    K getKey();
    V getValue();

}
