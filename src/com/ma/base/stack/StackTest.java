package com.ma.base.stack;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/10/28 14:58
 */
class StackData{
    String name;
    int age;
}

class Stacks {
    static final int MAXLEN = 50;
    StackData[] data = new StackData[MAXLEN + 1];
    int top;

    Stacks init() {
        Stacks p = new Stacks();
        if (p != null) {
            p.top = 0;
            return p;
        }
        return null;
    }

    boolean isEmpty(Stacks stack) {
        boolean result;
        result = (stack.top == 0);
        return result;
    }
    boolean isFull(Stacks stack) {
        boolean result;
        result = (stack.top == MAXLEN);
        return result;
    }
    void clear(Stacks stack) {
        stack.top = 0;
    }
    int push(Stacks stack, StackData data) {
        if ((stack.top + 1) > MAXLEN) {
            System.out.print("栈溢出!\n");
            return 0;
        }
        stack.data[++stack.top] = data;
        return 1;
    }

    StackData pop(Stacks stack) {
        if (stack.top == 0) {
            System.out.print("栈为空!\n");
//
            System.exit(0);
        }
        return stack.data[stack.top--];
    }

    StackData peek(Stacks stack) {
        if (stack.top == 0) {
            System.out.print("栈为空!\n");
//
            System.exit(0);
        }
        return stack.data[stack.top];
    }
    void free(Stacks stack) {
        if (stack != null) {
            stack = null;
        }
    }
}

public class StackTest {
}
