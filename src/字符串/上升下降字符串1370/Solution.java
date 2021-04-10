package 字符串.上升下降字符串1370;

/**
 * 给你一个字符串s，请你根据下面的算法重新构造字符串：
 *
 * 从 s中选出 最小的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s中选择字符。
 * 从 s中选出 最大的字符，将它 接在结果字符串的后面。
 * 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
 * 重复步骤 5，直到你没法从 s中选择字符。
 * 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将s中字符重新排序后的 结果字符串 。
 */
public class Solution {
    public String sortString(String s) {
        int[] box = new int[26];

        //char[] c = s.toCharArray();
        //这一步其实是多余的，可以直接遍历s字符串
        //但是直接读取char[]的速度会更快

        for(int i = 0;i<s.length();i++){
            box[s.charAt(i)-'a']++;
        }

        //String result="";
        //不要用String,字符串频繁改变的情况下，每一次都会生成新的String，占用空间和内存回收的时间；而StringBuffer始终就是一个对象，不需要内存回收
        //StringBudiler比StringBuffer更快，但是线程不安全

        StringBuilder ret = new StringBuilder();

        //boolean flag = true;
        //flag也是多余的 一个while循环里可以一前一后都扫描一遍

        while(true){
            for (int i = 0; i < 26; i++) {
                if (box[i] != 0) {
                    //result += String.valueOf((char)('a' + i));
                    ret.append((char)('a' + i));
                    box[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (box[i] != 0) {
                    //result += String.valueOf((char)('a' + i));
                    ret.append((char)('a' + i));
                    box[i]--;
                }
            }

            if(ret.length()==s.length()){
                return ret.toString();
            }
        }
    }
}
