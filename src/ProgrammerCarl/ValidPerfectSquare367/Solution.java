package ProgrammerCarl.ValidPerfectSquare367;

/**
 * Given a positive integer num,
 * return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer.
 * In other words, it is the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        long number = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            number = (long)mid * mid;
            if(number == num){
                return true;
            } else if(number < num){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
