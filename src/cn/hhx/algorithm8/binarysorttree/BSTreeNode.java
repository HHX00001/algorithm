package cn.hhx.algorithm8.binarysorttree;

/**
 * @author hhxStellar
 * @date 2021/10/17-10:39
 */
public class BSTreeNode {
    private int id;//节点的id
    private int value;//节点的值
    private BSTreeNode left;
    private BSTreeNode right;

    public BSTreeNode() {
    }

    public BSTreeNode(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    public void setRight(BSTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTreeNode{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
