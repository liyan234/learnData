package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> list = new ArrayList<>();
        triangle.add(list); // 一个链表中嵌套了一个链表
        triangle.get(0).add(1); //获取triangle中的第一个链表
        //然后向第一个链表中加入1

        //从1开始
        for (int i = 1; i < numRows; i++) {
            // 构造一个新链表
            List<Integer> newList = new ArrayList<>();
            // 获取上一个链表 来构造下一个链表
            List<Integer> oldList = triangle.get(i-1);
            //开始构造新链表
            newList.add(1);
            //如果是第二行的话 就不会进入这个for循环
            for (int j = 1; j < i; j++) {
                newList.add(oldList.get(j-1) + oldList.get(j));
            }
            newList.add(1);
            //往三角中加入链表
            triangle.add(newList);
        }

        return triangle;
    }
}
