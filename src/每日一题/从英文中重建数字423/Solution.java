package 每日一题.从英文中重建数字423;

import java.util.HashMap;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。
 * 按 升序 返回原始的数字。
 */
public class Solution {
    public String originalDigits(String s) {
        // 密码学的题
        // 有的字母只在一个数中出现 先找出来

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int[] result = new int[10];
        result[8] = map.getOrDefault('g',0);
        result[4] = map.getOrDefault('u',0);
        result[2] = map.getOrDefault('w',0);
        result[6] = map.getOrDefault('x',0);
        result[0] = map.getOrDefault('z',0);

        result[5] = map.getOrDefault('f',0) - result[4];
        result[3] = map.getOrDefault('h',0) - result[8];
        result[7] = map.getOrDefault('s',0) - result[6];


        result[1] = map.getOrDefault('o',0) - result[0]-result[2]-result[4];

        result[9] = (map.getOrDefault('n',0)-result[1] - result[7])/2;

        StringBuilder s_ = new StringBuilder();

        for(int i = 0;i<10;i++){
            for(int j = 0;j<result[i];j++){
                s_.append(i);
            }
        }

        return s_.toString();
    }
}
