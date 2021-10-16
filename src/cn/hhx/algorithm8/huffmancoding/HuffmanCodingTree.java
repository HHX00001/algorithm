package cn.hhx.algorithm8.huffmancoding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hhxStellar
 * @date 2021/10/16-13:35
 */
public class HuffmanCodingTree {
    private HuffmanCodingTreeNode root;
    private Map<Byte, String> codingMap;


    //返回编码表
    public Map<Byte, String> getCodingMap() {
        if (codingMap == null) {
            createEncoding();
        }
        return codingMap;
    }

    //根据传入的叶子节点构建huffman树
    public void construct(List<HuffmanCodingTreeNode> nodeList) {

        while (nodeList.size() > 1) {
            Collections.sort(nodeList);

            HuffmanCodingTreeNode left = nodeList.remove(0);
            HuffmanCodingTreeNode right = nodeList.remove(0);
            HuffmanCodingTreeNode parent = new HuffmanCodingTreeNode(left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);

            nodeList.add(parent);
        }
        root = nodeList.remove(0);
    }

    public void preOrderList() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        preOrderList(root);
    }

    private void preOrderList(HuffmanCodingTreeNode node) {
        System.out.println(node);
        if (node.getLeft() != null) {
            preOrderList(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrderList(node.getRight());
        }
    }

    //生成huffman编码表
    private void createEncoding() {
        if (root == null) {
            System.out.println("树不存在");
            return;
        }

        Map<Byte, String> codingMap = new HashMap<>();
        createEncoding(root, new StringBuilder(), codingMap);
        this.codingMap = codingMap;
    }

    //递归生成huffman编码表
    private void createEncoding(HuffmanCodingTreeNode node, StringBuilder str, Map<Byte, String> codingMap) {
        Byte data = node.getData();
        String str1 = str.toString();
        if (data != null) {
            codingMap.put(data, str1);
        }
        if (node.getLeft() != null) {
            createEncoding(node.getLeft(), new StringBuilder().append(str1).append(0), codingMap);
        }
        if (node.getRight() != null) {
            createEncoding(node.getRight(), new StringBuilder().append(str1).append(1), codingMap);
        }
    }


}
