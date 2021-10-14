package cn.hhx.algorithm7.binarytree;

/**
 * @author hhxStellar
 * @date 2021/10/14-13:08
 */
public class BinaryTree {
    private TreeNode root = new TreeNode(0, "根节点");

    public BinaryTree() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preorderPrint() {
        if (root != null)
            root.preorder();
        else
            System.out.println("二叉树为空");
    }

    public void inorderPrint() {
        if (root != null)
            root.inorder();
        else
            System.out.println("二叉树为空");
    }

    public void postorderPrint() {
        if (root != null)
            root.postorder();
        else
            System.out.println("二叉树为空");
    }

    public void preorderS(SearchCount count, TreeNode target) {
        root.preorderSearch(count, target);
    }

    public void inorderS(SearchCount count, TreeNode target) {
        root.inorderSearch(count, target);
    }

    public boolean postorderS(SearchCount count, TreeNode target) {
        return root.postorderSearch(count, target);
    }

    public boolean preDelete(TreeNode target) {
        return root.preOrderDelete(target);
    }
}
