package cn.hhx.algorithm7.arrbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-15:14
 */
public class ArrTreeNode {
    private int value;
    private ArrTreeNode left;
    private ArrTreeNode right;


    public ArrTreeNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrTreeNode(int value) {
        this.value = value;
    }

    public void setLeft(ArrTreeNode left) {
        this.left = left;
    }

    public void setRight(ArrTreeNode right) {
        this.right = right;
    }

    public ArrTreeNode getLeft() {
        return left;
    }

    public ArrTreeNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "ArrTreeNode{" +
                "value=" + value +
                '}';
    }
}
