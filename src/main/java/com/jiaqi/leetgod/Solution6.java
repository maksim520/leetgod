package com.jiaqi.leetgod;

import com.alibaba.fastjson.JSON;

import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * https://leetcode-cn.com/problems/sort-an-array/
 * https://blog.csdn.net/albert_smith/article/details/106053033
 */
class Solution6 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1,7,2,9,15,66,89,34,111,3};
        sortArray(nums);
        System.out.println(JSON.toJSONString(nums));
    }
    public static int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public static int randomizedPartition(int[] nums, int l, int r) {
        System.out.println("================================");
        System.out.println(JSON.toJSONString(nums));
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        System.out.println("当前主元是第" + i + "个：" + nums[i]);
        swap(nums, r, i);
        System.out.println(JSON.toJSONString(nums));
        return partition(nums, l, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
                System.out.println(JSON.toJSONString(nums));
            }
        }
        swap(nums, i + 1, r);
        System.out.println(JSON.toJSONString(nums));
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
