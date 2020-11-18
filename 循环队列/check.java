package 循环队列;

public class check {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);

        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));


    }
}
