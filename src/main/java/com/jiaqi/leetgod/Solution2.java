package com.jiaqi.leetgod;


/**给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 说明：你不能倾斜容器。
 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
 * 空间复杂度：O(1)，只需要额外的常数级别的空间。
 */
public class Solution2 {
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(nums);
        System.out.println(i);
    }
}

