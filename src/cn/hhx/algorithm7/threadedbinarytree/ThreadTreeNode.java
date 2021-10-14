package cn.hhx.algorithm7.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-17:55
 */
public class ThreadTreeNode {
    private String value;
    private ThreadTreeNode left;
    private ThreadTreeNode right;

    private boolean leftType; //true则是线索化，指向前驱(后驱),false则指向子树
    private boolean rightType;

    public ThreadTreeNode() {
    }

    public ThreadTreeNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ThreadTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadTreeNode left) {
        this.left = left;
    }

    public ThreadTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadTreeNode right) {
        this.right = right;
    }

    public boolean isLeftType() {
        return leftType;
    }

    public void setLeftType(boolean leftType) {
        this.leftType = leftType;
    }

    public boolean isRightType() {
        return rightType;
    }

    public void setRightType(boolean rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "ThreadTreeNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
