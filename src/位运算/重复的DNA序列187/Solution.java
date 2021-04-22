package 位运算.重复的DNA序列187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，
 * 例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()<=10){
            return result;
        }
        HashSet<String> set = new HashSet<>();
        int left = 0;
        int right = 10;
        while(right<=s.length()){
            if(set.contains(s.substring(left,right))){
                if(!result.contains(s.substring(left,right))){
                    result.add(s.substring(left,right));
                }
            }else{
                set.add(s.substring(left,right));
            }
            left++;
            right++;
        }
        return result;
    }
}
