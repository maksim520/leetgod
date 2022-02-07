package com.jiaqi.leetgod;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历，和层序遍历不一致
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution10 {
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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode listNode15 = new TreeNode(15,null,null);
        TreeNode listNode7 = new TreeNode(7,null,null);
        TreeNode listNode4 = new TreeNode(4,null,null);
        TreeNode listNode8 = new TreeNode(8,null,null);
        TreeNode listNode20 = new TreeNode(20,listNode15,listNode7);
        TreeNode listNode9 = new TreeNode(9,listNode4,listNode8);
        TreeNode listNode3 = new TreeNode(3,listNode9,listNode20);
        List<Integer> integers = preorderTraversal(listNode3);
        System.out.println(integers.toString());
    }
}
