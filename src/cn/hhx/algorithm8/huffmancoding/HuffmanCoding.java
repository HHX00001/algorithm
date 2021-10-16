package cn.hhx.algorithm8.huffmancoding;

import java.util.*;

/**
 * @author hhxStellar
 * @date 2021/10/16-13:13
 */
public class HuffmanCoding {
    public static void main(String[] args) {

        HuffmanCoding huffmanCoding = new HuffmanCoding();
        //将字符串转化为字节数组
        String s = "fuck u !! son of a bitch";
        byte[] preBytes = s.getBytes();

        Map<Byte, String> encodeMap = huffmanCoding.getEncodeMap(preBytes);

        byte[] zip = huffmanCoding.zip(preBytes, encodeMap);

        byte[] unzip = huffmanCoding.unzip(zip, encodeMap);
        for (byte elem : unzip) {
            System.out.print((char) elem);
        }
    }


    /**
     * 根据原文字节数组构建huffman编码树
     * 并获取huffman编码表
     *
     * @param preBytes
     * @return
     */
    public Map<Byte, String> getEncodeMap(byte[] preBytes) {
        HuffmanCodingTree huffmanCodingTree = new HuffmanCodingTree();
        huffmanCodingTree.init(preBytes);
        Map<Byte, String> codingMap = huffmanCodingTree.getCodingMap();

        return codingMap;
    }


    /**
     * 根据huffman编码表，将原有的数据字节数组转化为压缩后的字节数组
     *
     * @param preData
     * @param codingMap
     * @return
     */
    public byte[] zip(byte[] preData, Map<Byte, String> codingMap) {
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

        byte[] newByte = new byte[len + 1];
        newByte[0] = (byte) (stringBuilder.length() % 8);
        for (int i = 0, j = 1; i < stringBuilder.length() && j < newByte.length; i += 8, j++) {
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


    /**
     * 根据编码表，将压缩的字节数组解压为原文字节数组
     *
     * @param zipData
     * @param codingMap
     * @return
     */
    public byte[] unzip(byte[] zipData, Map<Byte, String> codingMap) {
        StringBuilder codeString = new StringBuilder();
        for (int i = 1; i < zipData.length - 1; i++) {
            codeString.append(byteToBit(zipData[i]));
        }
        codeString.append(byteToBit(zipData[zipData.length - 1], (int) zipData[0]));
        System.out.println(codingMap);

        Map<String, Byte> decodeMap = new HashMap<>();
        for (Map.Entry<Byte, String> elem : codingMap.entrySet()) {
            decodeMap.put(elem.getValue(), elem.getKey());
        }


        List<Byte> byteList = new ArrayList<>();
        int i = 0, j = 1;
        while (i < codeString.length()) {
            while (!decodeMap.containsKey(codeString.substring(i, j)) && j < codeString.length()) {
                j++;
            }
            byte matchByte = decodeMap.get(codeString.substring(i, j));
            byteList.add(matchByte);
            i = j;
            j = i + 1;
        }
        byte[] preBytes = new byte[byteList.size()];
        for (int k = 0; k < preBytes.length; k++) {
            preBytes[k] = byteList.get(k);
        }
        return preBytes;
    }

    /**
     * 将前面的字节转为二进制字符串
     *
     * @param preByte
     * @return
     */
    private String byteToBit(byte preByte) {
        int temp = preByte;
        temp |= 256;
        String string = Integer.toBinaryString(temp);
        string = string.substring(string.length() - 8);
        return string;
    }

    /**
     * 将最后一个字节转为二进制字符串
     *
     * @param preByte
     * @param i
     * @return
     */
    private String byteToBit(byte preByte, int i) {
        int temp = preByte;
        temp |= 256;
        String string = Integer.toBinaryString(temp);
        if (i != 0) {
            string = string.substring(string.length() - i);
        } else {
            string = string.substring(string.length() - 8);
        }
        return string;
    }
}
