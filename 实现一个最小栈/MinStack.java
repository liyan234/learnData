package 实现一个最小栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack; // 辅助栈

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    // 压栈
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
            return;
        }

        stack.push(x);
        if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    //出栈
    public void pop() {
        Integer x = stack.pop();
        if (x.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
