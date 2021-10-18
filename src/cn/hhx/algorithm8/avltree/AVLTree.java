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

    public void leftRotate() {
        leftRotate(root, null, false);
    }

    private void leftRotate(AVLTreeNode node, AVLTreeNode parent, boolean isLeft) {
        AVLTreeNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        if (parent != null) {
            if (isLeft) {
                parent.setLeft(newRoot);

            } else {
                parent.setRight(newRoot);

            }
        } else {
            root = newRoot;

        }
    }

    public void rightRotate() {
        rightRotate(root, null, false);
    }

    private void rightRotate(AVLTreeNode node, AVLTreeNode parent, boolean isLeft) {
        AVLTreeNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        if (parent != null) {
            if (isLeft) {
                parent.setLeft(newRoot);
            } else {
                parent.setRight(newRoot);
            }
        } else {
            root = newRoot;
        }
    }

    public void rotateAdjust() {
        rotateAdjust(root, null, false);
    }

    //有错误，待修改
    private void rotateAdjust(AVLTreeNode rootNode, AVLTreeNode parent, boolean isLeft) {
        if (rootNode.getLeft() != null) {
            rotateAdjust(rootNode.getLeft(), rootNode, true);
        }

        if (rootNode.getRight() != null) {
            rotateAdjust(rootNode.getRight(), rootNode, true);
        }

        int leftHeight = rootNode.getLeft() == null ? 0 : rootNode.getLeft().getHeight();
        int rightHeight = rootNode.getRight() == null ? 0 : rootNode.getRight().getHeight();

        while (leftHeight + 1 < rightHeight || leftHeight > rightHeight + 1) {
            if (leftHeight + 1 < rightHeight) {
                leftRotate(rootNode, parent, isLeft);
            } else {
                rightRotate(rootNode, parent, isLeft);
            }
            leftHeight = rootNode.getLeft() == null ? 0 : rootNode.getLeft().getHeight();
            rightHeight = rootNode.getRight() == null ? 0 : rootNode.getRight().getHeight();
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
