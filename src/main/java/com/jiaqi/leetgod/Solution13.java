package com.jiaqi.leetgod;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
 */
public class Solution13 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static List<List<Integer>> ret = new LinkedList<List<Integer>>();
    static Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    /**
     * 广度优先搜索
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public static void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }

    public static void main(String[] args) {
        TreeNode listNode2 = new TreeNode(2,null,null);
        TreeNode listNode7 = new TreeNode(7,null,null);
        TreeNode listNode5 = new TreeNode(5,null,null);
        TreeNode listNode1 = new TreeNode(1,null,null);
        TreeNode listNode13 = new TreeNode(13,null,null);
        TreeNode listNode11 = new TreeNode(11,listNode7,listNode2);
        TreeNode listNode4 = new TreeNode(4,listNode5,listNode1);
        TreeNode listNode8 = new TreeNode(8,listNode13,listNode4);
        TreeNode listNode42 = new TreeNode(4,listNode11,null);
        TreeNode listNode52 = new TreeNode(5,listNode42,listNode8);
        List<List<Integer>> lists = pathSum(listNode52, 22);
        System.out.println(lists.toString());
    }
}
