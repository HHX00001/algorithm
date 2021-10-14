package cn.hhx.algorithm7.binarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-13:19
 */
public class TestTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.getRoot();

        root.setLeftNode(new TreeNode(1, "惠恒星"));
        root.setRightNode(new TreeNode(2, "蒋卓成"));
        root.getRightNode().setRightNode(new TreeNode(3, "尚宇"));

//        binaryTree.preorderPrint(); //0 1 2 3
//        binaryTree.inorderPrint();//1 0 2 3
//        binaryTree.postorderPrint();

        SearchCount searchCount = new SearchCount();
        TreeNode target = new TreeNode(3, "尚宇");

//        binaryTree.preorderS(searchCount, target); //4
//        binaryTree.inorderS(searchCount, target); //4
//        boolean isFind = binaryTree.postorderS(searchCount, target);
//        System.out.println(isFind);
//        System.out.println(searchCount.getCount());

        System.out.println(binaryTree.preDelete(target));
        binaryTree.preorderPrint();


    }
}
