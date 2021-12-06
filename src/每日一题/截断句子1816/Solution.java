package 每日一题.截断句子1816;

import java.util.Arrays;

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。
 * 每个单词仅由大小写英文字母组成（不含标点符号）。
 *
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s和一个整数
 * k ，请你将 s 截断 ，使截断后的句子仅含 前 k个单词。
 * 返回 截断 s 后得到的句子。
 */
public class Solution {
    public String truncateSentence(String s, int k) {
        // 数组切片 Arrays.copyOfRange
        // 字符串join用String.join
        return String.join(" ", Arrays.copyOfRange(s.split(" "),0,k));
    }
}
