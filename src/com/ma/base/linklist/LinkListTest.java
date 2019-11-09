package com.ma.base.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/11/4 15:24
 */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LinkListTest {

    private Node head;
    private Node last;
    private int size;

    public void addEnd(int data) {
        Node insertNode = new Node(data);
        insertNode.next = null;
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = insertNode;
            last = insertNode;
        }
        size++;
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            last.next = insertNode;
            last = insertNode;
        } else {
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    /**
     * 获取下标为 index 的节点
     * @param index
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = prevNode.next.next;
        }
        size--;
        return removeNode;

    }


    public void removeTwo(int data) {
        if (head.data == data) {
            head = head.next;
        } else {
            Node node = head;
            Node temp = head.next;
            while (temp !=null) {
                if (temp.data == data) {
                    node.next = temp.next;
//                    break;
                    temp = temp.next;
                } else {
                    node = node.next;
                    temp = temp.next;
                }
            }
        }
    }

    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public void setCircle(int index) {
        Node temp = get(index);
        last.next = temp;
    }
    public boolean isCircle(Node head) {
        Node p1 = head;
        Node p2 = head;
        int time = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            time++;
            if (p1 == p2) {
                System.out.println(time);
                return true;
            }
        }
        return false;
    }
    public boolean isCircle2(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, i);
            i++;
            head = head.next;
        }
        return false;
    }

    public void reverse(Node head) {
        Node newHead = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = newHead;

            newHead = head;
            head = next;

            //node = head;
//            head = head.next;
//            node.next = newHead;
//            newHead = node;
        }
        this.head = newHead;
    }

    public Node getCountdown(int index) {
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("下标不正确");
        }
        int d = size - index;
        Node temp = head;
        for (int i = 0; i < d; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node getCountdownTwo(int index) {
        if (index <= 0 || index > size) {
            throw new IndexOutOfBoundsException("下标不正确!");
        }
        Node first = head;
        Node second = head;
        for (int i = 0; i < index; i++) {
            second = second.next;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public Node deleteCountdown(int index) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < index; i++) {
            second = second.next;
        }
        if (second == null) {
            return first.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;

        return head;
    }


    public int getMiddle() {
        Node one = head;
        Node two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one.data;
    }

    public int getMiddleTwo() {
        int mid = (size - 1) / 2;
        Node node = get(mid);
        return node.data;
    }

    public static Node merge(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head = null;
        if (head1.data > head2.data) {
            head = head2;
            head.next = merge(head1, head2.next);
        } else {
            head = head1;
            head.next = merge(head1.next, head2);
        }
        return head;
    }
    public static Node mergeTwo(Node head1, Node head2) {
        Node temp = new Node(0);
        Node head = temp;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 == null) temp.next = head2;
        if (head2 == null) temp.next = head1;
        return head.next;
    }

    public static void main(String[] args) {
        LinkListTest linkListTest = new LinkListTest();
        linkListTest.addEnd(25);
        linkListTest.insert(0, 3);
        linkListTest.insert(0, 4);
        linkListTest.insert(2, 9);
        linkListTest.insert(3, 5);
        linkListTest.insert(1, 6);
        linkListTest.addEnd(11);
        linkListTest.addEnd(48);
        linkListTest.addEnd(24);
        linkListTest.output();
        System.out.println(linkListTest.get(0).data);
        linkListTest.output();
        System.out.println("中间节点：" + linkListTest.getMiddle());
        System.out.println("中间节点：" + linkListTest.getMiddleTwo());
        System.out.println(linkListTest.getCountdown(6).data);
        System.out.println(linkListTest.getCountdownTwo(3).data);
        linkListTest.deleteCountdown(5);
        linkListTest.output();


//        linkListTest.reverse(linkListTest.head);
//        linkListTest.output();

//        linkListTest.setCircle(4);
//        System.out.println(linkListTest.isCircle(linkListTest.head));
//        System.out.println(linkListTest.isCircle2(linkListTest.head));

        LinkListTest head1 = new LinkListTest();
        head1.addEnd(4);
        head1.addEnd(9);
        head1.addEnd(10);
        head1.addEnd(15);

        LinkListTest head2 = new LinkListTest();
        head2.addEnd(5);
        head2.addEnd(7);
        head2.addEnd(12);
        head2.addEnd(14);
        head2.addEnd(26);
//        Node merge = merge(head1.head, head2.head);
//        while (merge != null) {
//            System.out.print(merge.data + " ");
//            merge = merge.next;
//        }
        System.out.println();

        Node mergeTwo = mergeTwo(head1.head, head2.head);
        while (mergeTwo != null) {
            System.out.print(mergeTwo.data + " ");
            mergeTwo = mergeTwo.next;
        }


    }
}
