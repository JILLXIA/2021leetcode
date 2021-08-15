package 每日一题.整数反转7;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围
 * [−231, 231− 1] ，就返回 0。
 */
public class Solution {
    public int reverse(int x) {
        Long temp1 = 1000000000L;
        Long temp2 = 1L;
        Long result = 0L;
        if(x>=Integer.MAX_VALUE || x<=Integer.MIN_VALUE){
            return 0;
        }
        int num = Math.abs(x);
        boolean isHigh = false;
        while(temp1>=1 && num!=0){
            if(num % temp1 == num && !isHigh){
                temp1 /= 10;
                continue;
            }
            isHigh = true;
            if(num % temp1 == num){
                temp1 /= 10;
                temp2 *= 10;
            }
            else{
                result += (num / temp1)*temp2;
                System.out.println(result);
                temp2 *= 10;
                num = num % temp1.intValue();
                temp1 /= 10;

            }
            if(result >= Integer.MAX_VALUE){
                return 0;
            }
        }
        return x>=0?result.intValue():-(result.intValue());
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.reverse(-2147483648));
    }
}
