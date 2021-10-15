package cn.test.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/15-17:06
 */
public class ThreadedTreeNode {
    private int value;
    private ThreadedTreeNode left;
    private ThreadedTreeNode right;

    private boolean isLeftThread;
    private boolean isRightThread;

    public ThreadedTreeNode() {
    }

    public ThreadedTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadedTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedTreeNode left) {
        this.left = left;
    }

    public ThreadedTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedTreeNode right) {
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
        return "ThreadedTreeNode{" +
                "value=" + value +
                '}';
    }
}
