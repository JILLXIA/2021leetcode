package Leetcode75.GreatestCommonDivisorOfStrings1071;

/**
 * For two strings s and t, we say "t divides s" if
 * and only if s = t + ... + t (i.e., t is concatenated
 * with itself one or more times).
 *
 * Given two strings str1 and str2,
 * return the largest string x such that x divides both str1 and str2.
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // need to find the gcd(str1.length(), str2.length())
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }

        int index = gcd(str1.length(), str2.length());

        return str1.substring(0, index);
    }

    // O(Log min(n1, n2))
    public int gcd(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
