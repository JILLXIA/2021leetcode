package 位运算.重复的DNA序列187;

/**
 * 位运算的解法 TODO
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 利用Robin Carp方法来匹配字符串，滚动计算字符串的hash值
 */
public class Solution1 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()<=10){
            return result;
        }
        int[] nums = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        Set<Integer> set = new HashSet<>();
        int hashcode = 0;
        int base = (int) Math.pow(4,10);
        for(int start = 0;start<nums.length-9;start++){
            if(start==0){
                for(int i = 0;i<10;i++){
                    hashcode = hashcode*4+nums[i];
                }
            }else{
                hashcode = 4*hashcode - nums[start-1]*base+nums[start+9];
            }
            if(set.contains(hashcode)&&!result.contains(s.substring(start,start+10))){
                result.add(s.substring(start,start+10));
            }else{
                set.add(hashcode);
            }
        }
        return result;
    }
}
