package com.ma.leetcode.recursion;

import java.util.Objects;

/**
 * @author Arlo
 * @version 1.0.0
 * @Description 递归相关算法
 * @ClassName RecursionAlgorithm.java
 * @createTime 2021年02月02日 13:19:00
 */
public class RecursionAlgorithm {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = null;
        if (l1.val > l2.val) {
            listNode = l2;
            listNode.next = mergeTwoLists(l1, l2.next);
        } else {
            listNode = l1;
            listNode.next = mergeTwoLists(l1.next, l2);
        }
        return listNode;


//        if (l1 == null) {
//            return l2;
//        } else if(l2 == null) {
//            return l1;
//        } else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1,l2.next);
//            return l2;
//        }
    }
    public static ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) temp.next = l2;
        if (l2 == null) temp.next = l1;
        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(7);
        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        ListNode ll1 = new ListNode(2);
        ListNode ll2 = new ListNode(4);
        ListNode ll3 = new ListNode(5);
        ListNode ll4 = new ListNode(7);
        ListNode ll5 = new ListNode(9);
        ll4.next = ll5;
        ll3.next = ll4;
        ll2.next = ll3;
        ll1.next = ll2;

        ListNode listNode = mergeTwoLists(l1, ll1);
        System.out.println(listNode);
    }
}
