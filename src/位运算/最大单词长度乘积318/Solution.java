package 位运算.最大单词长度乘积318;

/**
 * 给定一个字符串数组words，
 * 找到length(word[i]) * length(word[j])的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。
 * 如果不存在这样的两个单词，返回 0。
 */

/**
 * 每两个字符串先比较是否有公共字符，再更新result
 */
public class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        for(int i = 0;i<words.length;i++){
            for(int j = i+1;j< words.length;j++){
                if(nothasCommon(words[i],words[j])){
                    result = Math.max(result,words[i].length()*words[j].length());
                }
            }
        }
        return result;
    }

    public boolean nothasCommon(String a,String b){
        int resulta = 0;
        int resultb = 0;
        for(int i = 0;i<a.length();i++){
            resulta = resulta | 1<<(a.charAt(i)-'a');
        }
        for(int i = 0;i<b.length();i++){
            resultb = resultb | 1<<(b.charAt(i)-'a');
        }
        return (resulta & resultb)==0;
    }
}
