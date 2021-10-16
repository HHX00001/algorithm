package cn.hhx.algorithm8.huffman;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author hhxStellar
 * @date 2021/10/16-10:47
 */
public class HuffmanTree {
    private HuffTreeNode root;
    private int[] arr;

    public HuffmanTree() {
    }

    public HuffmanTree(int[] arr) {
        this.arr = arr;
    }

    public HuffTreeNode getRoot() {
        return root;
    }

    public void init() {
        ArrayList<HuffTreeNode> huffTreeNodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            huffTreeNodes.add(new HuffTreeNode(arr[i]));
        }
        Collections.sort(huffTreeNodes);


        while (huffTreeNodes.size() > 1) {
            HuffTreeNode left = huffTreeNodes.remove(0);
            HuffTreeNode right = huffTreeNodes.remove(0);

            HuffTreeNode parent = new HuffTreeNode(left.getValue() + right.getValue());
            parent.setLeft(left);
            parent.setRight(right);
            huffTreeNodes.add(parent);
            Collections.sort(huffTreeNodes);
        }
        root = huffTreeNodes.get(0);
    }


}
