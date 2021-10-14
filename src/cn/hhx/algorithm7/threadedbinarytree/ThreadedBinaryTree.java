package cn.hhx.algorithm7.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-17:55
 */
public class ThreadedBinaryTree {
    private ThreadTreeNode root = null;

    public ThreadedBinaryTree() {
    }

    public void threaded() {
        preOrderThreaded(root);
    }


    public void preOrderThreaded(ThreadTreeNode node) {
        if (node == null) {
            return;
        }


    }
}
