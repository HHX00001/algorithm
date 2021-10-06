package cn.hhx.algorithm.queue;


/**
 * @author hhxStellar
 * @date 2021/10/2-13:52
 */
public class CircleQueue {
    private int[] arr;
    private int front;//队列头
    private int rear;//队列尾的下一个元素的位置
    private int maxSize;//最大容量

    public CircleQueue() {
    }

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;//下一个待插入元素的位置
    }

    public void insert(int inputNum) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = inputNum;//插入一条数据
        rear = (rear + 1) % maxSize;//指向待添加的元素位置，也就是尾元素的后一位
    }

    public int get() {//取出一个数
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int pos = front;//指向队头元素
        front = (front + 1) % maxSize;
        return arr[front];


    }

    public void show() {

        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            int pos = i % maxSize;
            System.out.printf("arr[%-2d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

}
