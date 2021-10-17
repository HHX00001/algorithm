package cn.hhx.algorithm8.avltree;

/**
 * @author hhxStellar
 * @date 2021/10/17-22:05
 */
public class TestAVLTree {
    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();
        int[] arr = new int[]{4, 3, 6, 5, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTreeNode(i, arr[i]));
        }

        avlTree.inOrderList();
    }
}
