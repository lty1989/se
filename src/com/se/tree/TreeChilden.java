package com.se.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeChilden<E> {

    class Node<E> {


        E data;
        SonNode first;

        public Node(E data) {
            this.data = data;
            this.first = null;
        }
    }

    class SonNode {
        int pos;
        SonNode next;

        public SonNode(int pos, SonNode next) {
            this.pos = pos;
            this.next = next;
        }
    }

    private final int DEFAULT_SIZE = 100;
    private int treeSize = 0;
    private int nodeNum = 0;
    private Node[] nodes;

    public TreeChilden(E data) {

        treeSize = DEFAULT_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node(data);
        nodeNum++;
    }

    public TreeChilden(E data, int treeSize) {

        this.treeSize = treeSize;
        nodes = new Node[this.treeSize];
        nodes[0] = new Node(data);
        nodeNum++;
    }


    public void addNode(E data, Node parent) {


        for (int i = 0; i < treeSize; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node(data);
                if (parent.first == null) {
                    parent.first = new SonNode(i, null);
                } else {
                    SonNode next = parent.first;
                    while (next != null) {
                        next = next.next;
                    }
                    next.next = new SonNode(i, null);
                }
                nodeNum++;
                return;
            }

        }

    }


    public List<Node<E>> childen(Node parent) {
        List<Node<E>> list = new ArrayList<>();
        SonNode next = parent.first;
        while (next != null) {
            list.add(nodes[next.pos]);
            next = next.next;
        }
        return list;
    }

    public Node<E> childen(Node parent, int index) {
        SonNode next = parent.first;
        for (int i = 0; next != null; i++) {
            if (index == i) {
                return nodes[next.pos];
            }
            next = next.next;
        }
        return null;
    }

}
