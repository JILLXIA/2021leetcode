package 字符串.替换所有的问号1576;

/**
 * 从前面开始遍历，遇到问号就对比前面和后面的 用一个不与前面和后面一致的字符代替就好了
 *
 * 第一个和最后一个可以用补位的办法
 */
public class Solution1 {
    public String modifyString(String s) {
        char[] c = s.toCharArray();
        for(int i = 0;i<c.length;i++){
            if(c[i]=='?') {
                char left = i == 0 ? ' ' : c[i - 1];
                char right = i == c.length - 1 ? ' ' : c[i + 1];

                char tmp = 'a';
                while (tmp == left || tmp == right) {
                    tmp++;
                }
                c[i] = tmp;
            }
        }
        return String.valueOf(c);
    }
}
