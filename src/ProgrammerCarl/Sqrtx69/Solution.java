package ProgrammerCarl.Sqrtx69;

/**
 * Given a non-negative integer x,
 * return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        long number = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            number = (long)mid * mid;
            if(number==x){
                return mid;
            } else if(number < x){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
