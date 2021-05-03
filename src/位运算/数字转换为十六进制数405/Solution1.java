package 位运算.数字转换为十六进制数405;

/**
 * 先计算反过来的，然后再reverse
 */
public class Solution1 {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int tmp = 0x0000000f;
        while(num!=0){
            result.append(transNum(num&tmp));
            num = num>>>4;
        }
        return result.reverse().toString();
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
