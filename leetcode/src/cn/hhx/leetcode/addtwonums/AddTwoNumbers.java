package cn.hhx.leetcode.addtwonums;

/**
 * @author hhxStellar
 * @date 2021/10/4-0:37
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = new int[]{9,9,9,9,9,9,9};
        int[] nums2 = new int[]{9,9,9,9};
        ListNode listNode1 = createListNode(nums1);
        ListNode listNode2 = createListNode(nums2);

        ListNode resultListNode = addTwoNumbers(listNode1, listNode2);
        resultListNode.show();

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode temp = node;
        int sum = 0;
        int carry = 0;
        int n1 = 0;
        int n2 = 0;
        if (l1.next == null && l2.next == null) {
            sum = (l1.val + l2.val) % 10;
            carry = (l1.val + l2.val) / 10;
            temp.val = sum;
            if (carry != 0) {
                temp.next = new ListNode(carry);
            }
            return node;
        }

        while (true) {
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;
            sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            temp.val = sum;


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                if (carry != 0) {
                    temp.next = new ListNode(carry);
                }
                break;
            }
            temp.next = new ListNode();
            temp = temp.next;
        }
        return node;
    }

    public static ListNode createListNode(int[] nums) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;


        for (int i = 0; i < nums.length; i++) {
            temp.val = nums[i];
            temp.next = new ListNode();
            if (i == nums.length - 1) {
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        temp = null;
        return listNode;
    }

}
