package ByteDance.NextGreaterElementIII556;

import java.util.Arrays;

/**
 * Given a positive integer n,
 * find the smallest integer which has exactly the same digits existing
 * in the integer n and is greater in value than n.
 * If no such positive integer exists, return -1.
 *
 * Note that the returned integer should fit in 32-bit integer,
 * if there is a valid answer but it does not fit in 32-bit integer, return -1.
 */
public class Solution {
    public int nextGreaterElement(int n) {
        char[] number = (n+"").toCharArray();
        int i,j;
        for(i = number.length - 1;i>0;i--){
            if(number[i-1] < number[i]){
                break;
            }
        }

        if(i==0){
            return -1;
        }

        // II) Find the smallest digit on right side of (i-1)'th
        // digit that is greater than number[i-1]
        int x = number[i-1], smallest = i;
        for (j = i+1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;

        // III) Swap the above found smallest digit with
        // number[i-1]
        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;

        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
