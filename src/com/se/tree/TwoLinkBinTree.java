package com.se.tree;

public class TwoLinkBinTree<T> {

    private Object[] objects;
    private int DEFAULT_DEEP = 8;

    private int deep;
    private int arraySize;

    private Node root;

    class Node {
        T data;
        Node left;
        Node right;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public TwoLinkBinTree() {
        root = new Node();
    }

    public TwoLinkBinTree(T data) {
        root = new Node(data);
    }

    public Node addNode(Node parent, T data, boolean left) {
        if (parent == null) {
            throw new RuntimeException("不能为null");
        }

        if (left && parent.left != null) {
            throw new RuntimeException("左节点已经存在");
        }

        if (!left && parent.right != null) {
            throw new RuntimeException("右节点已经存在");
        }

        Node node = new Node(data);
        if (left) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return node;
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
