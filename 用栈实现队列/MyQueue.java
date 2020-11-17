package 用栈实现队列;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    //将元素 x 推到队列的末尾
    public void push(int x) {
        // 队列 先进先出  栈 先进后出

        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 当 stack2为空的时候
        // 将 stack1 中的元素 全部放入stack2中
        // stack1 中最底下的 就放到了 stack2 的最上面
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer x = stack1.pop();
                stack2.push(x);
            }
        }
        //如果 stack2 不为空的话
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
