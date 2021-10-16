package cn.hhx.algorithm8.huffmancoding;

import java.util.*;

/**
 * @author hhxStellar
 * @date 2021/10/16-13:13
 */
public class HuffmanCoding {
    public static void main(String[] args) {
        //将字符串转化为字节数组
        String s = "i like like like java do you like a java";
        byte[] preBytes = s.getBytes();
//        System.out.println(preBytes.length); 旧的长度为40
        //。。。

        byte[] zip = zip(preBytes);
//        System.out.println(zip.length); 新的长度为17
        byteToBit(zip[0]);

    }

    /**
     * 将传进的字节数组转化为叶子节点，含权值（字节出现的次数）和包含的数据（字节本身）
     * 返回一个包含所有叶子节点的List
     *
     * @param content
     * @return
     */
    private static List<HuffmanCodingTreeNode> getList(byte[] content) {
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

    public static byte[] zip(byte[] preBytes) {
        HuffmanCodingTree huffmanCodingTree = new HuffmanCodingTree();
        List<HuffmanCodingTreeNode> nodeList = getList(preBytes);

        //根据传入的叶子节点构建huffman树
        huffmanCodingTree.construct(nodeList);
        //获取编码表
        Map<Byte, String> codingMap = huffmanCodingTree.getCodingMap();

        byte[] zip = zip(preBytes, codingMap);

        return zip;
    }

    private static byte[] zip(byte[] preData, Map<Byte, String> codingMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte elem : preData) {
            stringBuilder.append(codingMap.get(elem));
        }

        int len = stringBuilder.length();
        if (len % 8 == 0) {
            len = len / 8;
        } else {
            len = len / 8 + 1;
        }

        byte[] newByte = new byte[len];
        for (int i = 0, j = 0; i < stringBuilder.length() && j < newByte.length; i += 8, j++) {
            String byteStr;
            if (i + 8 > stringBuilder.length()) {
                byteStr = stringBuilder.substring(i);
            } else {
                byteStr = stringBuilder.substring(i, i + 8);
            }
            newByte[j] = (byte) Integer.parseInt(byteStr, 2);
        }

        return newByte;
    }

    public static String unzip(byte[] zipData, Map<Byte, String> codingMap) {


        return null;
    }

    public static void byteToBit(byte preByte) {
        int temp = preByte;
        temp &= 255;
        String string = Integer.toBinaryString(temp);
        System.out.println(string);

    }
}
