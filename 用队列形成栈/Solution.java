package 用队列形成栈;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 入栈
        // 队列是先进先出
        // 栈是先进后出
        q2.offer(x); //进入队列2 最先进入队列2的 则出栈的是最先出的
        while (!q1.isEmpty()) {
            // 将队列1（先进先出）中所有依次的数放入队列2中
            Integer num = q1.poll();
            q2.offer(num);
        }
        // q2 和 q2 交换
        Queue<Integer>  queue = q1;
        q1 = q2;
        q2 = queue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //出栈
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        //取栈顶首元素
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return q1.isEmpty();
    }
}

