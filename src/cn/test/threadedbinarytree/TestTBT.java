package cn.test.threadedbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/15-17:44
 */
public class TestTBT {
    public static void main(String[] args) {
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        ThreadedBinaryTree tree = new ThreadedBinaryTree(arr);
        tree.preOrderConstruct();
        tree.preOrderThread();
        tree.preOrderList();
    }
}
