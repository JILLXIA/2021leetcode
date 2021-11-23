package 每日一题.亲密字符串859;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，
 * 就返回true；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，
 * 接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        int index1 = -1;
        int index2 = -1;
        Set<Character> set = new HashSet<>();
        boolean isSame = false;
        for(int i = 0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                isSame = true;
            } else {
                set.add(s.charAt(i));
            }
            if(s.charAt(i)!=goal.charAt(i)){
                if(index1==-1){
                    index1 = i;
                }else if(index2==-1){
                    index2 = i;
                }else{
                    return false;
                }
            }
        }
        if(index1 == -1){
            // 全部一毛一样
            return isSame;
        }else if(index2==-1){
            return false;
        }else {
            return s.charAt(index1)==goal.charAt(index2) && s.charAt(index2)==goal.charAt(index1);
        }
    }
}
