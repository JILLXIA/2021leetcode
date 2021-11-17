package 每日一题.最大单词长度乘积318;

import java.util.HashMap;

/**
 * 给定一个字符串数组words，找到length
 * (word[i]) * length(word[j])的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。
 * 如果不存在这样的两个单词，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 位运算，计算每个string的掩码，用int存储，两个int & 一下就知道有没有公共字母了
    public int maxProduct(String[] words) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // 也可以用两个长度相等的数组分别存储 mask 和 长度
        for(int i = 0;i<words.length;i++){
            int tmp = 0;
            for(int j = 0;j<words[i].length();j++){
                tmp = tmp | (1<<(words[i].charAt(j)-'a'));
            }
            // 如果mask一样 只存最大的
            if(!map.containsKey(tmp) || map.get(tmp) < words[i].length()) {
                map.put(tmp,words[i].length());
            }
        }
        int ans = 0;
        for(int a:map.keySet()){ // 遍历key的集合
            for(int b:map.keySet()){
                if((a&b) == 0){
                    // 没有重复的字母
                    ans = Math.max(ans,map.get(a) * map.get(b));
                }
            }
        }
        return ans;
    }

}
