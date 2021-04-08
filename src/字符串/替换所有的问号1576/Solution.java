package 字符串.替换所有的问号1576;

/**
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你 不能 修改非 '?' 字符。
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。
 * 如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 */

/**
 * 想的太复杂了，先用a填充，如果和左右有相同的再++
 */
public class Solution {
    public String modifyString(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length-1;
        while(left<=c.length-1 && c[left]=='?'){
            left++;
        }
        while(right>=0 && c[right]=='?'){
            right--;
        }
        if(left==c.length){
            for(int i = 0;i<c.length;i++){
                if(i==0){
                    c[i] = 'a';
                }else{
                    c[i] = findPost(c[i-1]);
                }
            }
            return String.valueOf(c);
        }
        if(left!=0){
            for(int i = left-1;i>=0;i--){
                c[i] = findPre(c[i+1]);
            }
        }
        if(right!=c.length-1){
            for(int i = right;i<c.length-1;i++){
                c[i+1] = findPost(c[i]);
            }
        }
        left++;
        while(left+1<=c.length-1 && left<=right){
            if(c[left]!='?'){
                left++;
                continue;
            }
            c[left] = findPost(c[left-1]);
            if(c[left]==c[left+1]){
                c[left] = findPost(c[left]);
            }
            left++;
        }
        return String.valueOf(c);
    }

    public static char findPre(char c){
        if(c=='a'){
            return 'z';
        }else{
            return (char)(c-1);
        }
    }

    public static char findPost(char c){
        if(c=='z'){
            return 'a';
        }else{
            return (char)(c+1);
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.modifyString("ubv?w"));
    }
}
