package cn.hhx.algorithm7.arrbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-14:53
 */
public class ArrBinaryTree {
    private ArrTreeNode root = null;
    private int[] arr;

    public ArrBinaryTree() {
    }

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void init() {
        if (arr == null || arr.length == 0) {
            System.out.println("数组非法");
            return;
        }
        int index = 0;
        root = new ArrTreeNode();
        preOrderConstruct(root, index);
    }

    public void preOrderConstruct(ArrTreeNode node, int index) {

        node.setValue(arr[index]);

        if ((index * 2 + 1) < arr.length) {
            node.setLeft(new ArrTreeNode());
            preOrderConstruct(node.getLeft(), index * 2 + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            node.setRight(new ArrTreeNode());
            preOrderConstruct(node.getRight(), index * 2 + 2);
        }
    }

    public void preOrder(ArrTreeNode node) {
        if (node != null) {
            System.out.println(node.toString());
        }
        if (node.getLeft() != null)
            preOrder(node.getLeft());
        if (node.getRight() != null)
            preOrder(node.getRight());
    }

    public void preOrderPrint() {
        preOrder(root);
    }
}
