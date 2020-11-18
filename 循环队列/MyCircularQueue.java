package 循环队列;

public class MyCircularQueue {

    public Integer[] queue;
    public int start;
    public int length;
    public int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        //构造器，设置队列长度为 k
        this.queue = new Integer[k];
        this.length = k;
        this.start = 0;
        this.size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //向循环队列插入一个元素。如果成功插入则返回真。
        if ( size == this.length) {
            //证明队列为满
           return false;
        }
        this.queue[(this.start + this.size) % length] = value;
        this.size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        //从循环队列中删除一个元素。如果成功删除则返回真
        //删除元素就是出队列

        //为空
        if (this.size == 0) {
            return false;
        }
        // 头指针向前进一位
        this.start = (this.start + 1) % this.length;
        this.size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        //从队首获取元素。如果队列为空，返回 -1
        if (this.size == 0) {
            return -1;
        }
        return this.queue[this.start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        //获取队尾元素。如果队列为空，返回 -1
        if (this.size == 0) {
            return -1;
        }
        int x = (this.start + this.size - 1) % this.length;
        return this.queue[x];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        //检查循环队列是否为空
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        //检查循环队列是否已满
        return (this.size == this.length);
    }

}


