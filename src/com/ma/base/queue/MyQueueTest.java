package com.ma.base.queue;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/11/8 14:11
 */
public class MyQueueTest {
    private int[] array;
    private int front;
    private int rear;

    public MyQueueTest(int capacity) {
        this.array = new int[capacity];
    }

    public void enterQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("列队已满！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int departureQueue() throws Exception {
        if (rear == front) {
            throw new Exception("列表已空！");
        }
        int deleteElement = array[front];
        front = (front + 1) % array.length;
        return deleteElement;
    }

    public int size() {
        return (rear - front + array.length) % array.length;
    }

    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        MyQueueTest myQueue = new MyQueueTest(6);
        myQueue.enterQueue(3);
        myQueue.enterQueue(5);
        myQueue.enterQueue(6);
        myQueue.enterQueue(8);
        myQueue.enterQueue(1);
        myQueue.departureQueue();
        myQueue.departureQueue();
        myQueue.departureQueue();
        myQueue.enterQueue(2);
        myQueue.enterQueue(4);
        myQueue.enterQueue(9);
        myQueue.output();
        int size = myQueue.size();
        System.out.println(size);
    }
}
