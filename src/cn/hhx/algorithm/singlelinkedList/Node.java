package cn.hhx.algorithm.singlelinkedList;

/**
 * @author hhxStellar
 * @date 2021/10/2-16:21
 */
public class Node {
    public int no;
    public String name;
    public Node nextNode;

    public Node() {
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
