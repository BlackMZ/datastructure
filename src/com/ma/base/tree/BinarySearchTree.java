package com.ma.base.tree;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2020/3/26 09:54
 */
public class BinarySearchTree {

    private Node tree;

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public void delete(int data) {
        // p指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp记录的是p的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        //没有找到要删除的节点
        if (p == null) return;

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            //查找右子树中最小节点
            Node minP = p.right;
            //minPP表示minP的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将minP的数据替换到p中
            p.data = minP.data;
            // 下面就变成了删除minP了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        // p的子节点
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        // 删除的是根节点
        if (pp == null) tree = child;
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public void preSort(Node root) {
        if (root == null) return;
        Node p = root;
        System.out.print(p.data + " ");
        preSort(p.left);
        preSort(p.right);
    }

    public void middleSort(Node root) {
        if (root == null) return;
        Node p = root;
        middleSort(p.left);
        System.out.print(p.data + " ");
        middleSort(p.right);
    }

    public void postSort(Node root) {
        if (root == null) return;
        Node p = root;
        postSort(p.left);
        postSort(p.right);
        System.out.print(p.data + " ");
    }
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(18);
        tree.insert(15);
        tree.insert(21);
        tree.insert(9);
        tree.insert(16);
        tree.insert(19);
        tree.insert(23);
        tree.insert(27);
        Node node = tree.find(19);
        System.out.println(node.data);
        Node max = tree.findMax();
        System.out.println(max.data);
        tree.preSort(tree.tree);
        System.out.println();
        tree.middleSort(tree.tree);
        System.out.println();
        tree.postSort(tree.tree);
    }

}
