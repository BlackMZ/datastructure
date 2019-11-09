package com.ma.base.queue;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/10/28 15:21
 */
class QueueData{
    String name;
    int age;
}

class Queue {
    static final int QUEUELEN = 15;
    QueueData[] data = new QueueData[QUEUELEN];
    int head;
    int tail;

    Queue init() {
        Queue q = new Queue();
        if (q != null) {
            q.head = 0;
            q.tail = 0;
            return q;
        }
        return null;
    }
    int isEmpty(Queue queue) {
        int temp = 0;
        if (queue.head == queue.tail) {
            temp = 1;
        }
        return temp;
    }

    int isFull(Queue queue) {
        int temp = 0;
        if (queue.tail == QUEUELEN) {
            temp = 1;
        }
        return temp;
    }

    void clear(Queue queue) {
        queue.head = 0;
        queue.tail = 0;
    }
    void free(Queue queue) {
        if (queue != null) {
            queue = null;
        }
    }

    int insert(Queue queue, QueueData data) {
        if (queue.tail == QUEUELEN) {
            System.out.print("队列已满!操作失败!\n");
            return(0);
        }
        queue.data[queue.tail++] = data;
        return 1;
    }

    QueueData out(Queue queue) {
        if (queue.head == queue.tail) {
            System.out.print("\n队列已空!操作失败!\n");

            System.exit(0);
        } else {
            return queue.data[queue.head++];
        }
        return null;
    }
    QueueData peek(Queue queue) {
        if (isEmpty(queue) == 1) {
            System.out.print("\n空队列!\n");
            return null;
        } else {
            return queue.data[queue.head];
        }
    }
    int length(Queue queue) {
        return queue.tail - queue.head;
    }

}

public class QueueTest {
}
