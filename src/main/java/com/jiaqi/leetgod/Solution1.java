package com.jiaqi.leetgod;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
class Solution1 {

    /**
     * 动态规划法：
     * 求第i天的最大利润max=prices[i]（当前值）-min（最小值）
     * 每次遍历都要判断min是不是前i个最小的 即min = Math.min(min,prices[i]);
     */
    public static int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int i = maxProfit(nums);
        System.out.println(i);
    }
}