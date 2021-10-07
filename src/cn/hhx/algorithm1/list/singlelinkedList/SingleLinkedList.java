package cn.hhx.algorithm1.list.singlelinkedList;

/**
 * 单链表及其操作
 *
 * @author hhxStellar
 * @date 2021/10/2-16:20
 */
public class SingleLinkedList {
    private Node head = new Node(0, "");//头节点不能动

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    //添加节点
    //不考虑编号顺序，找到最后一个节点，将next域指向新节点
    public void add(Node node) {
        //辅助node
        Node temp = head;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = node;
    }

    public void addById(Node node) {//根据节点的no插入
        Node temp = head;
        while (true) {
            if (temp.nextNode == null) {
                break;
            } else if (temp.nextNode.no > node.no) {
                break;
            } else if (temp.nextNode.no == node.no) {
                System.out.println(node + "排名节点已经存在");
                return;
            } else {
                temp = temp.nextNode;
            }
        }
        node.nextNode = temp.nextNode;
        temp.nextNode = node;
        System.out.println(node + "插入成功");
    }

    public void update(Node node) {//根据id更新节点
        Node temp = head.nextNode;//第一个元素

        if (temp == null) {
            System.out.println("链表为空");
        }

        while (temp != null) {
            if (temp.no == node.no) {
                System.out.print("原节点" + temp);
                temp.name = node.name;
                System.out.println("修改成功为" + temp);
                return;
            } else if (temp.nextNode == null) {
                System.out.println("未找到该排名NO:" + temp.no);
                return;
            } else {
                temp = temp.nextNode;
            }
        }
    }

    public void deleteById(int no) {
        Node temp = head;
        Node compareNode = head.nextNode;

        if (compareNode == null) {
            System.out.println("链表为空");
            return;
        }

        while (compareNode != null) {
            if (compareNode.no == no) {
                temp.nextNode = compareNode.nextNode;
                System.out.println(no + "节点删除成功");
                break;
            } else if (compareNode.nextNode == null) {
                System.out.println("要删除的节点" + no + "不存在");
                return;
            } else {
                temp = compareNode;
                compareNode = compareNode.nextNode;
            }
        }

    }

    public int getSize() {//得到有效节点数
        Node temp = head.nextNode;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.nextNode;
        }
        return count;
    }

    public Node getLastNoN(int n) {//得到倒数第几个节点
        int size = getSize();
        Node temp = head.nextNode;
        Node[] nodes = new Node[getSize()];

        for (int i = 0; i < size; i++) {
            nodes[i] = temp;
            temp = temp.nextNode;
        }
        return nodes[size - n];
    }

    public void reverseSGLL() {
        Node temp = head.nextNode;
        Node reverseTemp = temp;
        Node newHead = new Node();
        while (temp != null) {
            reverseTemp = reverseTemp.nextNode;
            temp.nextNode = newHead.nextNode;
            newHead.nextNode = temp;
            temp = reverseTemp;
        }
        head = newHead;
    }


    public void show() {
        Node temp = head.nextNode;
        if (temp == null) {
            System.out.println("链表为空");
        } else {
            while (temp != null) {
                System.out.println(temp);
                temp = temp.nextNode;
            }
        }
    }

}

