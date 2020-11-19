package 括号匹配问题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    // 利用
    public static boolean isValid(String s) {

        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Stack<Character> stack  = new Stack<>();

        Map<Character, Character> map= new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println(ch);
            // 就是如果map中含有这个key 则证明是右括号
            if (map.containsKey(ch)) {
                //没有包含就是左括号 要从栈中取出一个括号 看是否匹配
                //先判断栈是否为空
                if (stack.isEmpty()) {
                    System.out.println(1);
                    return false;
                }
                //ch 为左括号是map中的val
                //则从stack中取出这个一个括号 看是否匹配
                char x = stack.pop();

                if (x != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()";
        char x = s.charAt(0);
        System.out.println(x);
        boolean judge = isValid(s);
        System.out.println(judge);
    }
}
