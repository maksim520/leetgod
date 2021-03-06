package com.jiaqi.leetgod;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 */
class Solution {
    //二分法
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // 定义target在左闭右闭的区间，[low, high]
        int low = 0;
        int high = n - 1;
        while (low <= high) { // 当low==high，区间[low, high]依然有效
            int mid = low + (high - low) / 2; // 防止溢出
            if (nums[mid] > target) {
                high = mid - 1; // target 在左区间，所以[low, mid - 1]
            } else if (nums[mid] < target) {
                low = mid + 1; // target 在右区间，所以[mid + 1, high]
            } else {
                // 1. 目标值等于数组中某一个元素  return mid;
                return mid;
            }
        }
        // 2.目标值在数组所有元素之前 3.目标值插入数组中 4.目标值在数组所有元素之后 return right + 1;
        return high + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int i = searchInsert(nums, 0);
        System.out.println(i);
    }
}