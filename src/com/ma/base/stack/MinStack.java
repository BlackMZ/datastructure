package com.ma.base.stack;

import java.util.Stack;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/11/5 11:40
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        if (minStack.peek().equals(mainStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() throws Exception{
        if (minStack.empty()) {
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }
    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
