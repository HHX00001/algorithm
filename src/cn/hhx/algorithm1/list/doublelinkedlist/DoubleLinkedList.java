package cn.hhx.algorithm1.list.doublelinkedlist;

/**
 * @author hhxStellar
 * @date 2021/10/3-0:36
 */
public class DoubleLinkedList {
    private Node head = new Node(0, "");

    public Node getHeadNode() {
        return head;
    }

    public void list() {
        Node temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
        } else {
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    //添加一个节点到最后
    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //根据顺序添加
    public void addByOrder(Node node) {
        Node temp = head.next;

        if (temp == null) {
            head.next = node;
            node.pre = head;
            System.out.println("添加成功1");
            return;
        }
        Node tempTemp = null;
        while (temp != null) {
            tempTemp = temp;
            if (node.no == temp.no) {
                System.out.println("已存在改节点");
                return;
            } else if (node.no < temp.no) {
                temp.pre.next = node;
                node.pre = temp.pre;
                temp.pre = node;
                node.next = temp;
                System.out.println("添加成功");
                return;
            } else {
                temp = temp.next;
            }
        }
        tempTemp.next = node;
        node.pre = tempTemp;
        System.out.println("添加成功");
    }

    //更新一个节点
    public void updateById(Node node) {//根据id更新节点
        Node temp = head.next;//第一个元素


        while (temp != null) {
            if (temp.no == node.no) {
                System.out.print("原节点" + temp);
                temp.data = node.data;
                System.out.println("修改成功为" + temp);
                return;
            } else if (temp.next == null) {
                System.out.println("未找到该排名NO:" + temp.no);
                return;
            } else {
                temp = temp.next;
            }
        }

        System.out.println("该链表为空");
    }

    public void deleteById(int no) {

        if (head.next == null)
            System.out.println("链表为空");

        Node temp = head.next;
        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;

                if (temp.next == null) {
                    temp.next.pre = temp.pre;
                }
                System.out.println(no + "节点删除成功");
                break;

            } else if (temp.next == null) {
                System.out.println("要删除的节点" + no + "不存在");
                return;
            } else {
                temp = temp.next;
            }
        }
    }
}
