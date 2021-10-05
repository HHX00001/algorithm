package cn.hhx.leetcode.addtwonums;

import java.awt.*;

/**
 * @author hhxStellar
 * @date 2021/10/4-4:01
 */
public class AddTwoNumbers1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,2,4};
        int[] nums2 = new int[]{1,3,4,1,2};
        ListNode listNode1 = createListNode(nums1);
        ListNode listNode2 = createListNode(nums2);

        ListNode resultListNode = addTwoNumbers(listNode1, listNode2);
        resultListNode.show();

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode cursor = resultNode;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            sum = (l1val + l2val + carry) % 10;
            carry = (l1val + l2val + carry) / 10;

            cursor.next = new ListNode(sum);
            cursor = cursor.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

        }
        return resultNode.next;
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
