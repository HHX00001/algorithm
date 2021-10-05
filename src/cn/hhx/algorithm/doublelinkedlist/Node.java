package cn.hhx.algorithm.doublelinkedlist;

/**
 * @author hhxStellar
 * @date 2021/10/3-0:33
 */
public class Node {
    public int no;
    public String data;
    public Node pre;
    public Node next;


    public Node() {
    }

    public Node(int no, String data) {
        this.no = no;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}
