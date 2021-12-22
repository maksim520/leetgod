package com.jiaqi.leetgod;


import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。
 * 每个单词仅由大小写英文字母组成（不含标点符号）。
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子s和一个整数 k,请你将s截断,使截断后的句子仅含前 k个单词。返回截断s后得到的句子。
 * 链接：https://leetcode-cn.com/problems/truncate-sentence
 */
public class Solution3 {

    //由题意可知，除了最后一个单词，每个单词后面都跟随一个空格。
    //因此我们可以通过统计空格与句子结尾的数目来统计单词数count。
    //当count = k时，将当前的下标记录到end，返回句子s在end处截断的句子。
    //时间复杂度:O(N)，其中N为句子s的长度。遍历整个字符串需要O(N)。
    //空间复杂度:O(1)。注意返回值不计入空间复杂度。
    public static String truncateSentence(String s, int k) {
        int n = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        String s1 = truncateSentence(s, 4);
        System.out.println(s1);
    }
}
