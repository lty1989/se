package com.se.tree;

public class ArrayBinTree<T> {

    private Object[] objects;
    private int DEFAULT_DEEP = 8;

    private int deep;
    private int arraySize;

    public ArrayBinTree() {
        deep = DEFAULT_DEEP;
        arraySize = (int) Math.pow(2, deep) - 2;
        objects = new Object[arraySize];
    }

    public ArrayBinTree(int deep) {
        this.deep = deep;
        arraySize = (int) Math.pow(2, deep) - 2;
        objects = new Object[arraySize];
    }

    public ArrayBinTree(int deep, T data) {
        this.deep = deep;
        arraySize = (int) Math.pow(2, deep) - 2;
        objects = new Object[arraySize];
        objects[0] = data;
    }

    public void add(int index, T data, boolean left) {

        if (objects[index] == null) {
            throw new RuntimeException("节点为空 无法添加");
        }

        if (2 * index + 1 > arraySize) {
            throw new RuntimeException("树已满 无法添加");
        }

        if (left) {
            objects[2 * index + 1] = data;
        } else {
            objects[2 * index + 2] = data;
        }

    }

    public T parent(int index) {
        return (T) objects[(index - 1) / 2];
    }

    public T left(int index) {

        if (2 * index + 1 > arraySize) {
            throw new RuntimeException("叶子节点");
        }
        return (T) objects[2 * index + 1];
    }

    public T right(int index) {

        if (2 * index + 1 > arraySize) {
            throw new RuntimeException("叶子节点");
        }
        return (T) objects[2 * index + 2];
    }

    public int pos(T data) {

        for (int i = 0; i < arraySize; i++) {
            if (objects[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
}
