package 数据库阶段性考试;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            int x = help(str);
            System.out.println(x);
        }

    }

    private static int help(String str) {
        String strs[] = str.split(" ");
        int length = strs.length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(strs[i]);
        }
        return set.size();
    }

}
