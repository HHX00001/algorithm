package cn.hhx.algorithm.doublelinkedlist;

import org.junit.Test;

/**
 * @author hhxStellar
 * @date 2021/10/3-1:00
 */
public class TestDBLL {
    @Test
    public void test1() {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        Node node1 = new Node(3, "hhx");
        Node node2 = new Node(2, "sy");
        Node node3 = new Node(4, "jzc");
        Node node4 = new Node(1, "hbq");
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node4);
        System.out.println("--------打印链表------------");
        linkedList.list();
        System.out.println("------------打印删除后的链表----------");
        linkedList.deleteById(2);
        linkedList.list();
        System.out.println("---------修改列表------------");
        linkedList.updateById(new Node(1, "hhxlxy"));
        linkedList.list();

    }
}
