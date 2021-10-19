package cn.hhx.algorithm8.avltree;

import org.junit.Test;

/**
 * @author hhxStellar
 * @date 2021/10/17-22:05
 */
public class TestAVLTree {
    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();
        int[] arr = new int[]{7,6,5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTreeNode(i, arr[i]));
        }

        avlTree.inOrderList();
        System.out.println("---------------");
        avlTree.rotateAdjust();
        avlTree.inOrderList();
    }
}
