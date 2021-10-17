package cn.hhx.algorithm8.avltree;

/**
 * @author hhxStellar
 * @date 2021/10/17-15:36
 */
public class AVLTree {
    private AVLTreeNode root;

    public void add(AVLTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    private void add(AVLTreeNode cursor, AVLTreeNode node) {
        if (node.getValue() <= cursor.getValue()) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(node);
            } else {
                add(cursor.getLeft(), node);
            }
        }

        if (node.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                cursor.setRight(node);
            } else {
                add(cursor.getRight(), node);
            }
        }
    }

    public void inOrderList() {
        if (root == null) {
            System.out.println("树不存在");

        } else {
            inOrderList(root);
        }
    }

    private void inOrderList(AVLTreeNode node) {
        if (node.getLeft() != null) {
            inOrderList(node.getLeft());
        }

        System.out.println(node);

        if (node.getRight() != null) {
            inOrderList(node.getRight());
        }
    }

}
