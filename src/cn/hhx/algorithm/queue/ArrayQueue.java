package cn.hhx.algorithm.queue;


/**
 *  数组有问题,要使用环形队列
 * @author hhxStellar
 * @date 2021/10/2-13:15
 */
public class ArrayQueue {

    private int maxSize;//定义数组最大长度
    private int front;//队列头
    private int rear;//队列尾

    private int[] arr;//存放数据的数组

    public ArrayQueue() {
    }

    //队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾部
    }

    //判断为满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断为空
    public boolean isEmpty() {
        return rear == front;
    }

    //入队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法加入");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i : arr)
            System.out.printf("%-2d ", i);
        System.out.println();
    }
}