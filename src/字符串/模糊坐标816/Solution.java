package 字符串.模糊坐标816;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们有一些二维坐标，如"(1, 3)"或"(2, 0.5)"，
 * 然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 *
 * 原始的坐标表示法不会存在多余的零，
 * 所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
 * 此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 *
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 */

//没有考虑吧不带小数点的情况
public class Solution {
    public List<String> ambiguousCoordinates(String S) {
        String sb = S.substring(1,S.length()-1);
        List<String> s1;
        List<String> s2;
        List<String> result = new ArrayList<>();
        for(int i = 0;i<sb.length()-1;i++){
            String num1 = sb.substring(0,i+1);
            String num2 = sb.substring(i+1);
            s1 = isConvertNum(num1);
            s2 = isConvertNum(num2);
            StringBuilder tmp = new StringBuilder();
            if(!s1.isEmpty() && !s2.isEmpty()){
                for(int a = 0;a<s1.size();a++){
                    for(int b = 0;b<s2.size();b++){
                        tmp.append('(');
                        tmp.append(s1.get(a));
                        tmp.append(", ");
                        tmp.append(s2.get(b));
                        tmp.append(')');
                        result.add(tmp.toString());
                        tmp.delete(0,tmp.length());
                    }
                }
            }else{
                continue;
            }
        }
        return result;
    }

    public static List<String> isConvertNum(String s){

        char[] c = s.toCharArray();
        List<String> result = new ArrayList<>();
        if(s.length()==1){
            result.add(s);
            return result;
        }
        StringBuilder tmp = new StringBuilder(s);
        if(s.charAt(s.length()-1)=='0'){
            if(Integer.parseInt(s)!=0 && s.charAt(0)!='0'){
                result.add(s);
            }
            return result;
        }else if(s.charAt(0)=='0'){
            result.add(tmp.insert(1,".").toString());
        }else{
            result.add(s);
            for(int i = 1;i<=s.length()-1;i++){
                result.add(tmp.insert(i,".").toString());
                tmp.deleteCharAt(i);
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.ambiguousCoordinates("(0123)"));
    }
}
