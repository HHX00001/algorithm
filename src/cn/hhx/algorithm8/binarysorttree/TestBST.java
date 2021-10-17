package cn.hhx.algorithm8.binarysorttree;

import java.util.Arrays;

/**
 * @author hhxStellar
 * @date 2021/10/17-10:55
 */
public class TestBST {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            bsTree.add(new BSTreeNode(i, arr[i]));
        }
        bsTree.inOrderList();
        System.out.println(bsTree.getSize());

        for (int i = 0; i < arr.length; i++) {
            System.out.println("-----------");
            int randomInt = (int) (Math.random() * 7);
            System.out.println("删除的节点id为" + randomInt);
            bsTree.inOrderRemove(randomInt);
            bsTree.inOrderList();
            System.out.println(bsTree.getSize());
        }
        System.out.println("----------");

    }
}
