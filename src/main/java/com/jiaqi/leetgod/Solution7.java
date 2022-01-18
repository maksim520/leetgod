package com.jiaqi.leetgod;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Solution7 {
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode listNode9 = new TreeNode(9,null,null);
        TreeNode listNode15 = new TreeNode(15,null,null);
        TreeNode listNode7 = new TreeNode(7,null,null);
        TreeNode listNode20 = new TreeNode(20,listNode15,listNode7);
        TreeNode listNode3 = new TreeNode(3,listNode9,listNode20);
        List<List<Integer>> lists = levelOrder(listNode3);
        System.out.println(lists.toString());
    }
}
