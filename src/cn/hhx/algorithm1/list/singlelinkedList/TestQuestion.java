package cn.hhx.algorithm1.list.singlelinkedList;

import org.junit.Test;

import java.util.Stack;

/**
 * @author hhxStellar
 * @date 2021/10/2-18:07
 */
public class TestQuestion {

    @Test
    public void test() {
        Node node1 = new Node(1, "hhx");
        Node node2 = new Node(2, "jzc");
        Node node3 = new Node(3, "sy");
        Node node4 = new Node(4, "hbq");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addById(node2);
        singleLinkedList.addById(node3);
        singleLinkedList.addById(node1);
        singleLinkedList.addById(node4);

        System.out.println("------有效节点个数--------");
        System.out.println(singleLinkedList.getSize());
        System.out.println("----------倒数第几个打印-----------");
        System.out.println(singleLinkedList.getLastNoN(1));
        System.out.println("-------反转链表----------");
        singleLinkedList.reverseSGLL();
        singleLinkedList.show();
    }

    //用栈逆序打印
    @Test
    public void test2() {
        Node node1 = new Node(1, "hhx");
        Node node2 = new Node(2, "jzc");
        Node node3 = new Node(3, "sy");
        Node node4 = new Node(4, "hbq");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addById(node2);
        singleLinkedList.addById(node3);
        singleLinkedList.addById(node1);
        singleLinkedList.addById(node4);

        Stack<Node> nodesStack = new Stack<>();
        Node temp = singleLinkedList.getHead().nextNode;
        while (temp != null) {
            nodesStack.push(temp);
            temp = temp.nextNode;
        }

        System.out.println("----逆序打印-----------");
        while (nodesStack.size() > 0)
            System.out.println(nodesStack.pop());
    }

    //单向顺序链表的合并
    @Test
    public void test3() {
        Node node1 = new Node(1, "hhx");
        Node node2 = new Node(3, "jzc");
        Node node3 = new Node(6, "sy");
        Node node4 = new Node(9, "hbq");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addById(node2);
        singleLinkedList.addById(node3);
        singleLinkedList.addById(node1);
        singleLinkedList.addById(node4);

        node1 = new Node(2, "hhx");
        node2 = new Node(4, "jzc");
        node3 = new Node(7, "sy");
        node4 = new Node(8, "hbq");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addById(node2);
        singleLinkedList1.addById(node3);
        singleLinkedList1.addById(node1);
        singleLinkedList1.addById(node4);


        System.out.println("---------------");
        singleLinkedList.show();
        singleLinkedList1.show();


        System.out.println("----------------");

        Node temp1 = singleLinkedList.getHead().nextNode;//待插入元素
        Node temp2 = singleLinkedList1.getHead();//比较数
        Node temp11 = null;//记录待插入元素的后一个元素
        Node temp22 = null;//记录插入位置的前一个元素

        loop:
        while (temp1 != null) {
            temp11 = temp1.nextNode;
            while (temp2 != null) {
                temp22 = temp2;
                temp2 = temp2.nextNode;
                if (temp2.no > temp1.no) {
                    temp1.nextNode = temp2;
                    temp22.nextNode = temp1;
                    System.out.println(temp1 + "插入到" + temp2 + "之前");
                    temp2 = temp1;
                    break;
                } else if (temp2.nextNode == null) {
                    temp2.nextNode = temp1;
                    System.out.println(temp1 + "以及剩下的元素全部插入到" + temp2 + "之后");
                    break loop;
                }
            }
            temp1 = temp11;

        }

        System.out.println();
        singleLinkedList1.show();
    }
}
