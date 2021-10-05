package cn.hhx.algorithm.queue;

import java.util.Scanner;

/**
 * @author hhxStellar
 * @date 2021/10/2-14:48
 */
public class TestCircleQueue {
    public static void main(String[] args) {

        CircleQueue circleQueue = new CircleQueue(3);
        char key = ' ';
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("1显示队列");
            System.out.println("2添加队列数据");
            System.out.println("3取出队列数据");
            System.out.println("4推出出程序");
            System.out.println("请输入一个数");
            key = scanner.next().charAt(0);
            switch (key) {
                case '1':
                    circleQueue.show();
                    break;
                case '2':
                    System.out.println("插入一个数");
                    int i = scanner.nextInt();
                    circleQueue.insert(i);
                    break;
                case '3':
                    try {
                        circleQueue.show();
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
