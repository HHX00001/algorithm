package cn.hhx.algorithm7.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/15-16:07
 */
public class TestThreadTree {
    public static void main(String[] args) {
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        ThreadedBinaryTree tree = new ThreadedBinaryTree(arr);
        tree.preOrderConstruct();
        tree.preOrderThreaded();
        tree.preOrderList();
    }
}
