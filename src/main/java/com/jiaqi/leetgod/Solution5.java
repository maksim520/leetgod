package com.jiaqi.leetgod;

/**
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Solution5 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        public ListNode() {}
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        System.out.println(listNode1.toString());
        ListNode listNode = reverseList(listNode1);
        System.out.println(listNode.toString());
    }

}
