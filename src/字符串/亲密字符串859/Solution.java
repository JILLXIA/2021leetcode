package 字符串.亲密字符串859;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定两个由小写字母构成的字符串A和B，
 * 只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 * 就返回true；否则返回 false 。
 *
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），
 * 只要 i!=j 就交换 A[i] 和 A[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */

/**
 * 如果交换 A[i] 和 A[j] 可以证明 A 和 B 是亲密字符串，
 * 那么就有 A[i] == B[j] 以及 A[j] == B[i]。
 * 这意味着在 A[i], A[j], B[i], B[j] 这四个自由变量中，
 * 只存在两种情况：A[i] == A[j] 或 A[i] != A[j]
 */
public class Solution {
    public boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length()){
            return false;
        }else if(a.equals(b)){
            HashSet<Character> hasha = new HashSet<>();
            for(char c:a.toCharArray()){
                hasha.add(c);
            }
            return !(hasha.size()==a.length());
        }
        else{
            boolean flag = false;
            int firstIndex = -1;
            int secondIndex = -1;
            for(int i = 0;i<a.length();i++){
                if(a.charAt(i)==b.charAt(i)){
                    continue;
                }else{
                    if(firstIndex==-1){
                        firstIndex = i;
                    }else if(secondIndex==-1){
                        secondIndex = i;
                    }else{
                        return false;
                    }
                }
            }
            if(firstIndex==-1 || secondIndex==-1||!(a.charAt(firstIndex)==b.charAt(secondIndex)&&a.charAt(secondIndex)==b.charAt(firstIndex))){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.buddyStrings("ab","ba"));
    }
}
