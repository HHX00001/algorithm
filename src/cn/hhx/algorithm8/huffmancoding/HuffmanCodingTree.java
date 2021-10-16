package cn.hhx.algorithm8.huffmancoding;

import java.util.*;

/**
 * @author hhxStellar
 * @date 2021/10/16-13:35
 */
public class HuffmanCodingTree {
    private HuffmanCodingTreeNode root;
    private Map<Byte, String> codingMap;
    private List<HuffmanCodingTreeNode> nodeList;

    public HuffmanCodingTree() {

    }


    public void init(byte[] preBytes) {
        nodeList = getList(preBytes);
        construct(nodeList);
        createEncoding();
    }

    //返回编码表
    public Map<Byte, String> getCodingMap() {
        return codingMap;
    }

    /**
     * 将传进的字节数组转化为叶子节点，含权值（字节出现的次数）和包含的数据（字节本身）
     * 返回一个包含所有叶子节点的List
     *
     * @param content
     * @return
     */
    private List<HuffmanCodingTreeNode> getList(byte[] content) {
        List<HuffmanCodingTreeNode> contentList = new ArrayList<>();
        Map<Byte, Integer> contentMap = new HashMap<>();
        for (byte elem : content) {
            Integer count = contentMap.get(elem);
            if (count == null) {
                contentMap.put(elem, 1);
            } else {
                contentMap.put(elem, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> elem : contentMap.entrySet()) {
            contentList.add(new HuffmanCodingTreeNode(elem.getKey(), elem.getValue()));
        }


        return contentList;
    }


    //根据传入的叶子节点构建huffman树
    private void construct(List<HuffmanCodingTreeNode> nodeList) {

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

    /**
     * 打印huffman树
     */
    public void preOrderList() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        preOrderList(root);
    }

    /**
     * 递归打印huffman编码树
     *
     * @param node
     */
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
