package cn.hhx.algorithm8.huffmancoding;

import java.util.Map;

/**
 * @author hhxStellar
 * @date 2021/10/17-9:44
 */
public class TestZip {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        String s = "iiiidsadsakjfldasjdas;ljfs;lfsdlajds;";
        byte[] preData = s.getBytes();

        Map<Byte, String> encodeMap = huffmanCoding.getEncodeMap(preData);
        byte[] zip = huffmanCoding.zip(preData, encodeMap);
        System.out.println(preData.length + " " + zip.length);

    }
}
