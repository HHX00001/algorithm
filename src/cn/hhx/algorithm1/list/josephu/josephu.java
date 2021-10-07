package cn.hhx.algorithm1.list.josephu;

import cn.hhx.algorithm1.list.singlelinkedList.Node;
import cn.hhx.algorithm1.list.singlelinkedList.SingleLinkedList;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author hhxStellar
 * @date 2021/10/3-1:52
 */
public class josephu {
    @Test
    public void test() {
        int number = 5;
        int count = 2;

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.setHead(new Node(1, null));
        for (int i = 2; i <= number; i++) {
            singleLinkedList.add(new Node(i, null));
        }
        singleLinkedList.getLastNoN(1).nextNode = singleLinkedList.getHead();
        Node head = singleLinkedList.getHead();
        ArrayList<Node> order = new ArrayList<>();
        Node temp = head;
        while (temp.nextNode != temp) {
            for (int i = 1; i < count; i++) {
                temp = temp.nextNode;
            }
            order.add(temp);
            singleLinkedList.deleteById(temp.no);
            temp = temp.nextNode;
        }
        singleLinkedList.deleteById(temp.no);
        order.add(temp);
        System.out.println(order);

    }
}

