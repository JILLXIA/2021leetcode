package 每日一题.最长公共前缀14;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 尝试用前缀树的办法解决
        int[][] arr = new int[200][26];
        for(int i = 0;i<strs[0].length();i++){
            arr[i][strs[0].charAt(i)-'a'] = 1;
        }
        StringBuilder result = new StringBuilder(strs[0]);
        for(int i = 1;i<strs.length;i++){
            StringBuilder temp = new StringBuilder();
            for(int j = 0;j<strs[i].length();j++){
                if(arr[j][strs[i].charAt(j)-'a']==1){
                    temp.append(strs[i].charAt(j));
                } else {
                    break;
                }
            }
            if(temp.toString().equals("")){
                return "";
            } else {
                result = result.length() >= temp.length() ? temp : result;
            }
        }
        return result.toString();
    }
}
