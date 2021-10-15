package cn.hhx.algorithm7.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-17:55
 */
public class ThreadedBinaryTree {

    private ThreadTreeNode root = null;

    private ThreadTreeNode pre = null;//记录遍历时的前一个节点

    private int[] arr = null;

    public ThreadedBinaryTree() {
    }

    public ThreadedBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrderConstruct() {
        if (arr == null || arr.length == 0) {
            System.out.println("数组非法");
        }

        root = new ThreadTreeNode();
        preOrderConstruct(root, 0);

    }

    //构建一个前序顺序化二叉树
    private void preOrderConstruct(ThreadTreeNode node, int index) {

        node.setValue(arr[index]);

        if (index * 2 + 1 < arr.length) {
            node.setLeft(new ThreadTreeNode());
            preOrderConstruct(node.getLeft(), index * 2 + 1);
        }

        if (index * 2 + 2 < arr.length) {
            node.setRight(new ThreadTreeNode());
            preOrderConstruct(node.getRight(), index * 2 + 2);
        }
    }

    public void preOrderThreaded() {
        preOrderThreaded(root);
    }


    private void preOrderThreaded(ThreadTreeNode node) {
        if (node.getLeft() == null) {
            //如果左子树为空，则左指针指向前驱节点
            node.setLeft(pre);
            //左线索化标记为true
            node.setLeftThread(true);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightThread(true);
        }

        pre = node;

        if (node.getLeft() != null && !node.isLeftThread()) {
            preOrderThreaded(node.getLeft());
        }
        if (node.getRight() != null && !node.isRightThread()) {
            preOrderThreaded(node.getRight());
        }

    }

    public void preOrderList() {
        preOrderList(root);
    }

    private void preOrderList(ThreadTreeNode node) {
        while (node != null) {
            while (!node.isLeftThread() && node.getLeft() != null) {
                System.out.println(node);
                node = node.getLeft();
            }

            System.out.println(node);
            node = node.getRight();
        }
    }

}
