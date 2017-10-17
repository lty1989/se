package com.se.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortBinTree<T extends Comparable> {

    class Node {
        Object data;
        Node parent;
        Node left;
        Node right;


        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == this) {
                return true;
            }

            if (obj.getClass() == Node.class) {
                Node target = (Node) obj;
                return target.equals(data) && target.left == left && target.right == right;

            }
            return false;
        }
    }


    private Node root;

    public SortBinTree() {
        root = null;
    }

    public SortBinTree(T o) {
        root = new Node(o, null, null, null);
    }

    public void add(T o) {
        if (root == null) {
            root = new Node(o, null, null, null);
        } else {
            Node current = root;
            Node parent = null;
            int cmp = 0;
            do {
                parent = current;
                cmp = o.compareTo(current.data);
                if (cmp > 0) {
                    current = current.right;

                } else {
                    current = current.left;
                }
            } while (current != null);
            Node newNode = new Node(o, parent, null, null);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }

        }

    }

    /**
     * 根据值删除相应节点
     *
     * @param o
     */
    public void remove(T o) {
        Node target = getNode(o);
        if (target == null) {
            return;
        }

        if (target.left == null && target.right == null) {

            if (target == root) {
                root = null;
            } else if (target == target.parent.left) {
                target.parent.left = null;
            } else {
                target.parent.right = null;
            }
            target.parent = null;
        } else if (target.left == null && target.right != null) {
            if (target == root) {
                root = target.right;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.left;
                } else {
                    target.parent.right = target.right;
                }

            }
        } else {
            Node leftMaxNode = target.left;
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            leftMaxNode.parent.right = null;
            leftMaxNode.parent = target.parent;
            if (target == target.parent.left) {
                target.parent.left = leftMaxNode;
            } else {
                target.parent.right = leftMaxNode;
            }
            leftMaxNode.left = target.left;
            leftMaxNode.right = target.right;
            target.parent = null;
            target.left = null;
            target.right = null;
        }

    }


    /**
     * 根据给定的值 检索节点
     *
     * @param o 值
     * @return 节点
     */
    public Node getNode(T o) {
        Node p = root;
        while (p != null) {
            int cmp = o.compareTo(p.data);
            if (cmp < 0) {
                p = p.left;
            } else if (cmp > 0) {
                p = p.right;
            } else {
                return p;
            }

        }
        return null;
    }

    public List<Node> breadth() {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }

            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }

}
