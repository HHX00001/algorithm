package cn.hhx.algorithm8.binarysorttree;


/**
 * @author hhxStellar
 * @date 2021/10/17-10:39
 */
public class BSTree {
    private BSTreeNode root;
    private int size;

    public BSTree() {
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加一个节点
     *
     * @param node
     */
    public void add(BSTreeNode node) {
        if (node == null) {
            System.out.println("待添加节点信息错误");
            return;
        }
        if (this.root == null) {
            size++;
            this.root = node;
        } else {
            add(this.root, node);
        }
    }

    /**
     * 递归找到添加节点的位置
     *
     * @param cursor 指向与待添加节点比较的节点
     * @param node   待添加节点
     */
    private void add(BSTreeNode cursor, BSTreeNode node) {
        if (node == null) {
            return;
        }

        if (node.getValue() <= cursor.getValue()) {
            if (cursor.getLeft() == null) {
                size++;
                cursor.setLeft(node);
            } else {
                add(cursor.getLeft(), node);
            }
        }

        if (node.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                size++;
                cursor.setRight(node);
            } else {
                add(cursor.getRight(), node);
            }
        }
    }

    /**
     * 按照id删除节点
     * 过滤掉待删除节点是root节点的情况
     *
     * @param id
     */
    public void inOrderRemove(int id) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        if (id == root.getId()) {
            BSTreeNode left = root.getLeft();
            BSTreeNode right = root.getRight();
            if (left == null && right == null) {
                root = null;
                size--;
                return;
            }

            if (left != null && right != null) {
                root = left;
                add(root, right);
                size -= 2;
            } else {
                root = left == null ? right : left;
                size--;
            }

        } else {
            inOrderRemove(id, root, null, true);
        }
    }

    /**
     * 递归删除除了根节点之外的节点
     *
     * @param id     待删除节点的id
     * @param node   待确定的待删除节点
     * @param parent 待确定的待删除节点的父节点
     * @param isLeft 待确定的待删除节点在父节点的位置（是父节点的左子节点(true)还是右子节点(false)）
     */
    private void inOrderRemove(int id, BSTreeNode node, BSTreeNode parent, boolean isLeft) {
        //左子树不为空，则继续向左递归
        if (node.getLeft() != null) {
            inOrderRemove(id, node.getLeft(), node, true);
        }

        //确定待删除节点（与id值比较），确定之后进行删除
        if (node.getId() == id) {
            BSTreeNode left = node.getLeft();//拿到待删除节点的左子节点
            BSTreeNode right = node.getRight();//拿到待删除节点的右子节点

            if (isLeft == true) {//判断待删除节点是左子节点还是右子节点
                parent.setLeft(null);
                size--;
            } else {
                parent.setRight(null);
                size--;
            }

            if (left != null) {//如果待删除节点的左子节点（子树）不为null则插入以父节点为根节点的子树
                add(parent, left);
                size--;//左子节点先前就已经存在，所以插入时将多余的size++减去
            }
            if (right != null) {//...
                add(parent, right);
                size--;
            }
        }

        //。。。
        if (node.getRight() != null) {
            inOrderRemove(id, node.getRight(), node, false);
        }
    }

    /**
     * 递归中序遍历二叉树的起点
     */
    public void inOrderList() {
        if (root == null) {
            System.out.println("二叉树不存在");
            return;
        } else {
            inOrderList(root);
        }

    }

    /**
     * 递归遍历二叉树的递归体
     *
     * @param node
     */
    private void inOrderList(BSTreeNode node) {
        if (node.getLeft() != null) {
            inOrderList(node.getLeft());
        }

        System.out.println(node);

        if (node.getRight() != null) {
            inOrderList(node.getRight());
        }
    }
}
