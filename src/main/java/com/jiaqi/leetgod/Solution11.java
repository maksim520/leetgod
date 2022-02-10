package com.jiaqi.leetgod;

/**
 *给你两个版本号 version1 和 version2 ，请你比较它们。
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class Solution11 {
    /**
     * 方法一：字符串分割
     * 时间复杂度：O(n+m)（或者O(max(n,m))，这是等价的），其中 n 是字符串 version1 的长度，m 是字符串version2 的长度。
     * 空间复杂度：O(n+m)，我们需要 O(n+m) 的空间存储分割后的修订号列表。
     */
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 方法二：双指针
     * 方法一需要存储分割后的修订号，为了优化空间复杂度，我们可以在分割版本号的同时解析出修订号进行比较。
     * 时间复杂度：O(n+m)，其中 n 是字符串 version1 的长度，m 是字符串 version2 的长度。
     * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
     */
    public static int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            //遇到.for循环停止
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            //遇到.for循环停止
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int s = '1'- '0';//结果等于1，字符串1的10进制ASCII码是49，字符串0的10进制ASCII码是48，结果得到1。
        int i = compareVersion2("1.01", "1.001");
        System.out.println(i);
    }
}
