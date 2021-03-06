package 位运算.数字转换为十六进制数405;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。
 * 对于负整数，我们通常使用补码运算方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 */
public class Solution {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        StringBuffer result = new StringBuffer();
        int tool = 0xf0000000;
        for(int i = 0;i<8;i++){
            int tmp = (tool & num)>>>((7-i)*4);
            tool = tool >>> 4;
            if(tmp==0 && result.length()==0){
                continue;
            }
            result.append(transNum(tmp));
        }
        return result.toString();
    }

    public String transNum(int num){
        switch(num){
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
            case 15:
                return "f";
            default:
                return String.valueOf(num);
        }
    }
}
