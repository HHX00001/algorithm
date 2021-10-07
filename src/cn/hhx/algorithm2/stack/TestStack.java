package cn.hhx.algorithm2.stack;

import org.junit.Test;

/**
 * @author hhxStellar
 * @date 2021/10/6-14:36
 */
public class TestStack {
    @Test
    public void test() {
        ArrayStack arrayStack = new ArrayStack(8);
        for (int i = 0; i < 8; i++) {
            arrayStack.push((int) (Math.random() * 100));
        }
        arrayStack.list();

        arrayStack.push(11);
    }
}
