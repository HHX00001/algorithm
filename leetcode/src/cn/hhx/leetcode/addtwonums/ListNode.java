package cn.hhx.leetcode.addtwonums;

import java.util.Stack;

/**
 * @author hhxStellar
 * @date 2021/10/4-0:38
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void show() {
        ListNode temp = this;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (stack.size() > 0)
            System.out.printf("%-2d ", stack.pop());
    }
}

