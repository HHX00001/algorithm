package cn.hhx.algorithm.singlelinkedList;

/**
 * @author hhxStellar
 * @date 2021/10/2-16:39
 */
public class TestSGLL {
    public static void main(String[] args) {
        Node node1 = new Node(1, "hhx");
        Node node2 = new Node(2, "jzc");
        Node node3 = new Node(3, "sy");
        Node node4 = new Node(4, "hbq");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addById(node2);
        singleLinkedList.addById(node3);
        singleLinkedList.addById(node1);
        singleLinkedList.addById(node4);
        singleLinkedList.show();

        System.out.println("-------更新节点---------");
        Node updateNode = new Node(41, "hbqqqqqq");
        singleLinkedList.update(updateNode);
        singleLinkedList.show();

        System.out.println("--------删除节点------");
        singleLinkedList.deleteById(1);
        singleLinkedList.show();
    }
}
