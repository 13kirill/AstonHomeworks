package ru.zubkov.astonhomeworks;

public interface List<E> {
    void add(E e);
    void add(int index, E e);
    boolean addAll(List<? extends E> c);
    void clear();
    E get(int index);
    boolean isEmpty();
    void remove(int index);
    boolean remove(Object o);
    void sort();
    int size();
}
