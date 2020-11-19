package 斐波那契数;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            System.out.println(help(x));
        }
    }

    private static int help (int x) {
        int a = 0;
        int b = 1;
        while (x > b) {
            int tmp = a;
            a = b;
            b = tmp + b;
        }
        return Math.min((b - x), (x - a));
    }

    private static int fib(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        return fib(x - 1) + fib(x - 2);
    }
}
