package cn.hhx.algorithm8.huffman;


/**
 * @author hhxStellar
 * @date 2021/10/16-11:09
 */
public class TestHuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 20);
//        }
        HuffmanTree huffmanTree = new HuffmanTree(arr);
        huffmanTree.init();
        System.out.println(huffmanTree.getRoot());
    }

}
