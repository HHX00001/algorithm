package cn.test.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/15-17:09
 */
public class ThreadedBinaryTree {

    private ThreadedTreeNode root;
    private int[] arr;
    private ThreadedTreeNode pre;

    public ThreadedBinaryTree() {
    }

    public ThreadedBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrderConstruct() {
        if (arr == null || arr.length == 0) {
            System.out.println("数组非法");
            return;
        }
        root = new ThreadedTreeNode();
        preOrderConstruct(root, 0);
    }

    private void preOrderConstruct(ThreadedTreeNode node, int index) {
        node.setValue(arr[index]);
        if (index * 2 + 1 < arr.length) {
            node.setLeft(new ThreadedTreeNode());
            preOrderConstruct(node.getLeft(), index * 2 + 1);
        }

        if (index * 2 + 2 < arr.length) {
            node.setRight(new ThreadedTreeNode());
            preOrderConstruct(node.getRight(), index * 2 + 2);
        }
    }

    public void preOrderThread() {
        preOrderThread(root);
    }

    private void preOrderThread(ThreadedTreeNode node) {
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftThread(true);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightThread(true);
        }

        pre = node;

        if (node.getLeft() != null && !node.isLeftThread()) preOrderThread(node.getLeft());
        if (node.getRight() != null && !node.isRightThread()) preOrderThread(node.getRight());
    }


    public void preOrderList() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        preOrderList(root);
    }

    private void preOrderList(ThreadedTreeNode node) {
        System.out.println(node);

        if (node.getLeft() != null && !node.isLeftThread())
            preOrderList(node.getLeft());

        if (node.getRight() != null && !node.isRightThread())
            preOrderList(node.getRight());
    }

}
