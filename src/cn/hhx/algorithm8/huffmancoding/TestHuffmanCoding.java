package cn.hhx.algorithm8.huffmancoding;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hhxStellar
 * @date 2021/10/16-14:09
 */
public class TestHuffmanCoding {
    public static void main(String[] args) {
        List<byte[]> charList = new ArrayList<>();
        String s = "哈哈哈  哈哈哈";


//        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println(stringBuilder.toString());

//        List<byte[]> bytesList = new ArrayList<>();
//        String bitStr = "惠恒星";
//        String[] split1 = bitStr.split("");
//        for (int i = 0; i < split1.length; i++) {
//            bytesList.add(split1[i].getBytes(StandardCharsets.UTF_8));
//        }
//        for (byte[] temp : bytesList) {
//            System.out.println(new String(temp, StandardCharsets.UTF_8));
//        }


        String str = "10001";
//        System.out.println(Integer.valueOf(str, 2));
//        byte bbb = Integer.valueOf(str, 2).byteValue();
//        System.out.println(bbb);


        byte myByte = Byte.parseByte(str, 2);
        System.out.println(myByte);

        byte i = 1;
        int i1 = i;
        System.out.println(Integer.toBinaryString(i1));
        i1 |= 256;
        System.out.println(Integer.toBinaryString(i1));
    }
}
