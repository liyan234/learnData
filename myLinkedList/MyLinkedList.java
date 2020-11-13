package myLinkedList;

class Node {
    public int val; // 存储的值
    public Node next; // 存放的下一个节点

    public Node(int val) {
        this.val = val;
    }


}

public class MyLinkedList {

    // 头节点
    private Node head = null;
    private int size = 0;

    //头插法
    public void add (int val) {
        if (this.head == null) {
            this.head = new Node(val);
            this.size++;
            return;
        }
        Node node = new Node(val);
        //头插法
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    //向表中间的插入一个数
    public void insertNum(int index, int num) {
        // index 不符合条件 插入失败
        // size 的话 无法为插
        // size 加1的话 可以将这个数字插入尾部
        if (index > size + 1 || index < 0) {
            return;
        }
        Node node = new Node(num);
        Node cur = this.head;
        Node pre = null;
        int i = 1;
        while (cur != null && i < index) {
            pre = cur;
            cur = cur.next;
            i++;
        }
        // index == 1 时候
        if (pre == null) {
            node.next = this.head;
            this.head = node;
            this.size++;
            return;
        }
        // 其他时候
        pre.next = node;
        node.next = cur;
        this.size++;
    }

    //删除一个数
    public boolean remove(int num) {
        Node cur = this.head;
        Node pre = null;
        while (cur != null) {
            if (cur.val == num) {
                if (pre == null) {
                    this.head = this.head.next;
                } else {
                    pre.next = cur.next;
                }
                this.size--;
                return true;
            }
            pre = cur;
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int length() {
        return this.size;
    }


    public void  prin() {
        Node cur = this.head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

}
