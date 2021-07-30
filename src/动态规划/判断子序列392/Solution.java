package 动态规划.判断子序列392;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）
 * 字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
 * 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        // 最简单使用双指针的做法
        int index1 = 0;
        int index2 = 0;
        while(index1<t.length()){
            if(index2>=s.length()){
                return true;
            }
            if(s.charAt(index2)==t.charAt(index1)){
                index2++;
                index1++;
            }else{
                index1++;
            }
        }
        if(index2==s.length()){
            return true;
        }else {
            return false;
        }

    }
    public static void main(String[] args){
        Solution s = new Solution();
        s.isSubsequence("axc","ahbgdc");
    }
}
