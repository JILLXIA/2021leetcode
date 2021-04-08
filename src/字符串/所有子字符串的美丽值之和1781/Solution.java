package 字符串.所有子字符串的美丽值之和1781;

/**
 * 一个字符串的 美丽值定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 * 比方说，"abaacc"的美丽值为3 - 1 = 2。
 * 给你一个字符串s，请你返回它所有子字符串的美丽值之和。
 */

import java.util.TreeMap;

/**
 * 遍历大于等于3的字串，每个字串计算美丽值
 */

/**
 * 下面写的这种方法不行哦，因为TreeMap是按照key的值排序的，但是题目需要找最大和最小的value值
 * 因为字符串只在a-z之间，用一个长度为26的数组就可以解决了
 */
public class Solution {
    public int beautySum(String s) {
        if(s.length()<=2){
            return 0;
        }else{
            TreeMap<Character,Integer> map = new TreeMap<>();
            char[] c = s.toCharArray();

            int result = 0;
            for(int i = 0;i<s.length()-2;i++){
                map.put(c[i],map.getOrDefault(c[i],0)+1);
                map.put(c[i+1],map.getOrDefault(c[i],0)+1);
                for(int j = i+2;j<s.length();j++){
                    map.put(c[j],map.getOrDefault(c[j],0)+1);
                    int tmp = 0;
                    if(map.size()<=1){
                        tmp = 0;
                    }else{
                        tmp = map.get(map.lastKey())-map.get(map.firstKey());
                    }
                    result +=tmp;
                }
                map.clear();
            }
            return result;
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.beautySum("aabcbaa"));
    }

}
