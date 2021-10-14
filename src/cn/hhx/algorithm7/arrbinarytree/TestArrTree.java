package cn.hhx.algorithm7.arrbinarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-14:53
 */
public class TestArrTree {
    public static void main(String[] args) {
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.init();

        arrBinaryTree.preOrderPrint();
    }
}
