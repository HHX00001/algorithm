package cn.hhx.algorithm8.avltree;

import org.junit.Test;

/**
 * @author hhxStellar
 * @date 2021/10/17-22:05
 */
public class TestAVLTree {
    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();
        int[] arr = new int[]{4, 3, 6, 5, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTreeNode(i, arr[i]));
        }

        avlTree.inOrderList();
        System.out.println("---------------");
        avlTree.leftRotate();
        avlTree.inOrderList();
    }

    @Test
    public void test() {
        AVLTree avlTree = new AVLTree();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTreeNode(i, arr[i]));
        }

        avlTree.inOrderList();
        System.out.println("---------------");
//        avlTree.rightRotate();
        avlTree.inOrderList();
    }

    @Test
    public void test1() {
        AVLTree avlTree = new AVLTree();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTreeNode(i, (int) (Math.random() * 20)));
        }

        avlTree.inOrderList();
        System.out.println("---------------");
        avlTree.rotateAdjust();
        avlTree.inOrderList();
    }
}
