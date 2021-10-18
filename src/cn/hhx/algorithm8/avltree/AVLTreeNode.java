package cn.hhx.algorithm8.avltree;

/**
 * @author hhxStellar
 * @date 2021/10/17-15:36
 */
public class AVLTreeNode {
    private int id;
    private int value;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public AVLTreeNode() {
    }

    public AVLTreeNode(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getHeight() {
        return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }




    @Override
    public String toString() {
        return "AVLTreeNode{" +
                "value=" + value +
                '}';
    }
}
