package com.jiaqi.leetgod;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
 */
public class Solution12 {
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
    static Deque<Integer> path = new LinkedList<Integer>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    /**
     * 方法一：深度优先搜索
     * offerLast(element)指定元素添加在列表的末尾，pollLast()返回列表的最后一个元素并从列表中移除
     */
    public static void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
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
