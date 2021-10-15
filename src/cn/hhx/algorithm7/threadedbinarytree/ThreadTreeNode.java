package cn.hhx.algorithm7.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-17:55
 */
public class ThreadTreeNode {
    private int value;
    private ThreadTreeNode left;
    private ThreadTreeNode right;

    private boolean isLeftThread; //true则是线索化，指向前驱(后驱),false则指向子树
    private boolean isRightThread;

    public ThreadTreeNode() {
    }

    public ThreadTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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

    public boolean isLeftThread() {
        return isLeftThread;
    }

    public void setLeftThread(boolean leftThread) {
        isLeftThread = leftThread;
    }

    public boolean isRightThread() {
        return isRightThread;
    }

    public void setRightThread(boolean rightThread) {
        isRightThread = rightThread;
    }

    @Override
    public String toString() {
        return "ThreadTreeNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
