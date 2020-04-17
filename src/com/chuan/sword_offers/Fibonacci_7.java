package com.chuan.sword_offers;

/**
 * @author hechuan
 */
public class Fibonacci_7 {

    public int Fibonacci(int n) {
        if (n < 0) { throw new RuntimeException("Invalid input!"); }

        int f0 = 0, f1 = 1;
        if (n == 0) { return f0; }
        if (n == 1) { return f1; }

        for (int i = 2; i <= n; i++) {
            f1 += f0;
            f0 = f1 - f0;
        }

        return f1;
    }
}
