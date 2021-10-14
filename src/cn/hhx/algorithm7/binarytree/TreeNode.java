package cn.hhx.algorithm7.binarytree;

import java.util.Objects;

/**
 * @author hhxStellar
 * @date 2021/10/14-12:53
 */
public class TreeNode {
    private int id;
    private String value;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode() {
    }

    public TreeNode(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void preorder() {
        if (this != null)
            System.out.println(this.toString());

        if (this.leftNode != null)
            this.leftNode.preorder();

        if (this.rightNode != null)
            this.rightNode.preorder();
    }

    public void inorder() {
        if (this.leftNode != null)
            this.leftNode.inorder();

        if (this != null)
            System.out.println(this.toString());

        if (this.rightNode != null)
            this.rightNode.inorder();
    }

    public void postorder() {

        if (this.leftNode != null)
            this.leftNode.postorder();

        if (this.rightNode != null)
            this.rightNode.postorder();

        if (this != null)
            System.out.println(this.toString());
    }

    public void preorderSearch(SearchCount count, TreeNode target) {
        if (this != null) {
            count.increment();
            if (this.equals(target)) {
                System.out.println(this.toString());
                return;
            }
        }

        if (this.leftNode != null)
            this.leftNode.preorderSearch(count, target);

        if (this.rightNode != null)
            this.rightNode.preorderSearch(count, target);
    }

    public void inorderSearch(SearchCount count, TreeNode target) {
        if (this.leftNode != null)
            this.leftNode.inorderSearch(count, target);

        if (this != null) {
            count.increment();
            if (this.equals(target)) {
                System.out.println(this.toString());
                return;
            }
        }

        if (this.rightNode != null)
            this.rightNode.inorderSearch(count, target);
    }

    public boolean postorderSearch(SearchCount count, TreeNode target) {
        if (this.leftNode != null)
            if (this.leftNode.postorderSearch(count, target))
                return true;

        if (this.rightNode != null)
            if (this.rightNode.postorderSearch(count, target))
                return true;

        if (this != null) {
            count.increment();
            if (this.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean preOrderDelete(TreeNode target) {
        if (this.leftNode != null) {
            if (this.leftNode.equals(target)) {
                this.leftNode = null;
                return true;
            } else if (this.leftNode.preOrderDelete(target))
                return true;
        }

        if (this.rightNode != null) {
            if (this.rightNode.equals(target)) {
                this.rightNode = null;
                return true;
            } else if (this.rightNode.preOrderDelete(target))
                return true;
        }

        return false;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return id == treeNode.id && Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, leftNode, rightNode);
    }
}
