package Top100Question.ReverseInteger7;

/**
 * Given a signed 32-bit integer x,
 * return x with its digits reversed.
 * If reversing x causes the value to go outside
 * the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to
 * store 64-bit integers (signed or unsigned).
 */
public class Solution {
    public int reverse(int x) {
        // a = x % 10
        // x = x / 10
        // result  = result * 10 + a
        int result = 0;
        while(x!=0){
            int remainder = x % 10;
            x = x / 10;
            // no long format
            if(result > Integer.MAX_VALUE / 10 || (result ==Integer.MAX_VALUE/10 && remainder > 7)){
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result ==Integer.MAX_VALUE/10 && remainder < -8)){
                // 负数的remainder也是负数
                return 0;
            }
            result = result * 10 + remainder;
        }

        return result;

    }
}
