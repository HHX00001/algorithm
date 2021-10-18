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

    private AVLTreeNode leftRotate(AVLTreeNode node, AVLTreeNode parent, boolean isLeft) {
        if (node.getRight() != null) {
            AVLTreeNode right = node.getRight();
            while (right.getLeftHeight() > right.getRightHeight()) {
                right = rightRotate(right, node, false);
            }
        }

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
        return newRoot;
    }

    public void rightRotate() {
        rightRotate(root, null, false);
    }

    private AVLTreeNode rightRotate(AVLTreeNode node, AVLTreeNode parent, boolean isLeft) {
        if (node.getLeft() != null) {
            AVLTreeNode Left = node.getLeft();
            while (Left.getRightHeight() > Left.getLeftHeight()) {
                Left = leftRotate(Left, node, true);
            }
        }

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
        return newRoot;
    }

    public void rotateAdjust() {
        rotateAdjust(root, null, false);
    }

    private void rotateAdjust(AVLTreeNode rootNode, AVLTreeNode parent, boolean isLeft) {
        if (rootNode.getLeft() != null) {
            rotateAdjust(rootNode.getLeft(), rootNode, true);
        }

        if (rootNode.getRight() != null) {
            rotateAdjust(rootNode.getRight(), rootNode, false);
        }

        while (rootNode.getLeftHeight() + 1 < rootNode.getRightHeight() || rootNode.getLeftHeight() > rootNode.getRightHeight() + 1) {
            if (rootNode.getLeftHeight() + 1 < rootNode.getRightHeight()) {
                rootNode = leftRotate(rootNode, parent, isLeft);
            } else {
                rootNode = rightRotate(rootNode, parent, isLeft);
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
