package cn.hhx.algorithm.queue;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author hhxStellar
 * @date 2021/10/2-13:34
 */
public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("1显示队列");
            System.out.println("2添加队列数据");
            System.out.println("3取出队列数据");
            System.out.println("4推出程序");
            System.out.println("请输入一个数");
            key = scanner.next().charAt(0);
            switch (key) {
                case '1':
                    arrayQueue.showQueue();
                    break;
                case '2':
                    System.out.println("输入一个数");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case '3':
                    try {
                        int res = arrayQueue.getQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    loop = false;
                    break;

            }
        }
    }
}
