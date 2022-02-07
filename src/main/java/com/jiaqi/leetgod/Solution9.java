package com.jiaqi.leetgod;

/**
 * 删除排序链表中的重复元素 II
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution9 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode44 = new ListNode(4,listNode5);
        ListNode listNode4 = new ListNode(4,listNode44);
        ListNode listNode32 = new ListNode(3,listNode4);
        ListNode listNode3 = new ListNode(3,listNode32);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        System.out.println(listNode1.toString());
        ListNode listNode = deleteDuplicates(listNode1);
        System.out.println(listNode.toString());
    }
}
