package cn.hhx.algorithm3.recursiontest;

import org.junit.Test;

/**
 * 递归调用机制
 *
 * @author hhxStellar
 * @date 2021/10/7-16:25
 */
public class TestRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

    //简单递归打印
    public static void test(int i) {
        if (i > 1) {
            test(i - 1);
        }
        System.out.println(i);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
