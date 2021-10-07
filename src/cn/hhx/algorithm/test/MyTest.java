package cn.hhx.algorithm.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author hhxStellar
 * @date 2021/10/2-13:51
 */
public class MyTest {
    @Test
    public void test() {
        int[] arr = new int[10];
        System.out.println(arr.length);
    }

    @Test
    public void test1() {
        int[] ints = new int[10];
        System.out.println(ints.length);
    }

    @Test
    public void test2() {
        ArrayList<String> strings = new ArrayList<>();

        strings.add(0, "aaa");
        strings.add(0, "ddd1");
        System.out.println(strings);
    }


}
