package Grind75.ValidPalindrome125;

/**
 * A phrase is a palindrome if,
 * after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters,
 * it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left > right){
                break;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
