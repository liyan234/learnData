package myStack;

class Node {
    public Integer val;
    public Node next;

    public Node(Integer val) {
        this.val = val;
    }
}

// 链式结构的栈
public class myStack {

    private Node head = null; //头节点
    private int size = 0;

    // 栈 先进后出

    // 压栈  O(1)
    public void push (int x) {
        if (this.head == null) {
            this.head = new Node(x);
            this.size++;
            return;
        }
        // 先进后出的话 我们要使用尾插法
        Node node = new Node(x);
        node.next = this.head;
        this.head = node;
        this.size++;
    }


    // 取栈顶元素 O(1)
    public Integer peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.val;
    }

    //出栈 O(1)
    public Integer pop() {
        if (this.head == null) {
            return null;
        }
        Integer num = this.head.val;
        this.head = this.head.next;
        this.size--;
        return num;
    }


}
