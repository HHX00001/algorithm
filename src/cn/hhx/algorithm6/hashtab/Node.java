package cn.hhx.algorithm6.hashtab;

/**
 * @author hhxStellar
 * @date 2021/10/13-16:10
 */
public class Node {
    int key;
    String value;

    Node next;

    public Node() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
