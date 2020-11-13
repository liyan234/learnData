package myArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class check {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        int x = list.indexOf(1);
        System.out.println(x);
        list.prin();

    }
}
