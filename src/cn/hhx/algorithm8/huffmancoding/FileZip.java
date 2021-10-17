package cn.hhx.algorithm8.huffmancoding;

import java.io.*;
import java.util.Map;

/**
 * @author hhxStellar
 * @date 2021/10/17-9:19
 */
public class FileZip {
    public static void main(String[] args) {
        FileZip fileZip = new FileZip();

        fileZip.unzip("C:\\Users\\Reformer\\Desktop\\压缩文件.zip", "C:\\Users\\Reformer\\Desktop\\解压txt");
    }

    public void zip(String src, String des) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(src);
            byte[] preData = new byte[fis.available()];
            fis.read(preData);

            Map<Byte, String> encodeMap = huffmanCoding.getEncodeMap(preData);
            byte[] zipData = huffmanCoding.zip(preData, encodeMap);
            fos = new FileOutputStream(des);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(zipData);
            oos.writeObject(encodeMap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void unzip(String src, String des) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);
            ois = new ObjectInputStream(fis);

            byte[] zipData = (byte[]) ois.readObject();
            Map<Byte, String> encodeMap = (Map<Byte, String>) ois.readObject();
            byte[] unzip = huffmanCoding.unzip(zipData, encodeMap);

            fos.write(unzip);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
