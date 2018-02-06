package com.se.dongnao.tree;

import java.util.Stack;

/**
 * Created by lty on 2018-2-6.
 */
public class BinaryTree {

    private Node root = null;

    public BinaryTree(String data) {
        this.root = new Node(data);
    }

    class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public void createTree() {
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        root.left = nodeB;
        root.right = nodeC;

        nodeB.left = nodeD;

        nodeC.left = nodeE;
        nodeC.right = nodeF;


    }


    private void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println("-->" + node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    /**
     * 前序遍历
     */
    private void preOrder() {
        preOrder(root);
    }


    private void preOrderMom(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (stack.size() > 0) {
            Node n = stack.pop();
            System.out.println("->" + n.data);
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }

    }

    /**
     * 前序遍历 非遍历
     */
    private void preOrderMom() {
        preOrderMom(root);
    }


    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            return (left > right) ? left + 1 : right + 1;
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    public Node createTree1(String[] str, int index, int size) {
        if (index == size) {
            return null;
        }
        String s = str[index];
        Node node = null;
        if ("#".equals(s)) {
            index++;
            return node;
        }
        node = new Node(s);
        if (index == 0) {
            root = node;
        }
        index++;
        node.left = createTree1(str, index, str.length);
        node.right = createTree1(str, index, str.length);
        return node;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree("A");
        //tree.createTree();
        //tree.preOrder();
        //tree.preOrderMom();


        String s = "A,B,D,#,#,E,#,#,C,#,F,#,#";
        String[] str = s.split(",");
        tree.createTree1(str, 0, str.length);
        tree.preOrderMom();


        //System.out.println(tree.getHeight());
    }

}
