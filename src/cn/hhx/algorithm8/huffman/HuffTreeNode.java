package cn.hhx.algorithm8.huffman;

/**
 * @author hhxStellar
 * @date 2021/10/16-10:59
 */
public class HuffTreeNode implements Comparable<HuffTreeNode> {
    private int value;
    private HuffTreeNode left;
    private HuffTreeNode right;

    public HuffTreeNode() {
    }

    public HuffTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HuffTreeNode getLeft() {
        return left;
    }

    public void setLeft(HuffTreeNode left) {
        this.left = left;
    }

    public HuffTreeNode getRight() {
        return right;
    }

    public void setRight(HuffTreeNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffTreeNode o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "HuffTreeNode{" +
                "value=" + value +
                '}';
    }

}
