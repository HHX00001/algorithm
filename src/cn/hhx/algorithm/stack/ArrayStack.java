package cn.hhx.algorithm.stack;

/**
 * 用数组实现栈
 * <p>
 * 并实现计算器
 *
 * @author hhxStellar
 * @date 2021/10/6-14:16
 */
public class ArrayStack {
    private int stackCapability;//栈的容量
    private int[] stack;//数组存放栈的数据
    private int top = -1;//栈顶

    public ArrayStack(int stackCapability) {
        this.stackCapability = stackCapability;
        stack = new int[stackCapability];
    }

    public boolean isFull() {
        return top == stackCapability - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int n) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        } else {
            top++;
            stack[top] = n;
        }
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    public int peek() {
        return stack[top];
    }

    //从top开始打印
    public void list() {
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d ", i, stack[i]);
        }
        System.out.println();
    }

}
