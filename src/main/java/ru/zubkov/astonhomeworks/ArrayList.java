package ru.zubkov.astonhomeworks;

public class ArrayList<E> implements List<E> {

    private E[] list;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public ArrayList() {
        list = (E[]) new Object[DEFAULT_SIZE];
    }

    public ArrayList(int capacity) {
        if (capacity >= 0) {
            throw new IllegalArgumentException("Размер массива не может быть меньше 0!");
        } else {
            list = (E[]) new Object[capacity];
        }
    }

    @Override
    public void add(E e) {
        list[size++] = e;
    }

    @Override
    public void add(int index, E e) {
        for (int i = size; i < index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = e;
        size++;
    }

    @Override
    public boolean addAll(List<? extends E> c) {
        int oldSize = size;
        for (int i = 0; i < c.size(); i++) {
            add(i + oldSize, c.get(i));
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
    }

    @Override
    public E get(int index) {
        return list[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
    }

    @Override
    public boolean remove(Object o) {
        boolean b = false;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                remove(i);
                b = true;
            }
        }
        return b;
    }

    @Override
    public void sort() {
        quickSort(list, 0, size - 1);
    }

    @Override
    public int size() {
        return size;
    }

    public void quickSort(Object arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(Object[] arr, int left, int right) {
        E pivot = (E) arr[left];

        while (left <= right) {
            while (((E) arr[left]).compareTo(pivot) < 0) {
                left++;
            }

            while (((E) arr[right]).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                E tmp = (E) arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }
}
