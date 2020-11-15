package myQueue;

class Node {
    public Integer val;
    public Node next;

    public Node(Integer val) {
        this.val = val;
    }
}


// 链表法
public class myQueue {

    private Node head = null;
    private Node tail = null;
    // 设置了一个tail 来定义标识尾部  以便于入队
    private int size = 0;

    //先进先出的数据结构
    // 入队 O(1)
    public Integer offer(int x) {
        Node num = new Node(x);
        if (this.head == null) {
            this.head = num;
            this.tail = num;
            this.size++;
            return x;
        }
        //尾插
        this.tail.next = num;
        this.tail = num;
        this.size++;
        return x;
    }

    // 出队  0(1)
    public Integer poll() {
        if (this.head == null) {
            return -1;
        }
        Integer x = this.head.val;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        this.size--;
        return x;
    }

    // 获取队守元素
    public Integer peek() {
        if (this.head == null) {
            //throw new RuntimeException("队列为空");
            return -1;
        }
        return head.val;
    }

}
