package cn.hhx.algorithm8.huffmancoding;

/**
 * @author hhxStellar
 * @date 2021/10/16-13:36
 */
public class HuffmanCodingTreeNode implements Comparable<HuffmanCodingTreeNode> {
    private Byte data;
    private int weight;
    private HuffmanCodingTreeNode left;
    private HuffmanCodingTreeNode right;

    public HuffmanCodingTreeNode() {
    }

    public HuffmanCodingTreeNode(int weight) {
        this.weight = weight;
    }

    public HuffmanCodingTreeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanCodingTreeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanCodingTreeNode left) {
        this.left = left;
    }

    public HuffmanCodingTreeNode getRight() {
        return right;
    }

    public void setRight(HuffmanCodingTreeNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanCodingTreeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanCodingTreeNode{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }
}
