package com.ma.leetcode;

import java.util.Stack;

/**
 * @Author: John.ma
 * @Description: 用栈实现队列
 * @Date: 2019/11/15 09:33
 */
public class QueueWithStack {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入栈
     * @param element 元素
     */
    public void push(int element) {
        stackA.push(element);
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {
                return null;
            }
            reverse();
        }
        return stackB.pop();
    }

    /**
     * 将栈A移到栈B
     */
    public void reverse() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        QueueWithStack stack = new QueueWithStack();
        stack.push(5);
        stack.push(3);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
