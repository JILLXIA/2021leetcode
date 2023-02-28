package ProgrammerCarl.ReverseStringII541;

/**
 * Given a string s and an integer k,
 * reverse the first k characters for every 2k
 * characters counting from the start of the string.
 *
 * If there are fewer than k characters left,
 * reverse all of them. If there are less than 2k but greater than or
 * equal to k characters,
 * then reverse the first k characters and leave the other as original.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int left = 0;
        int right = Math.min(k-1, sArr.length-1);
        int count = 0;

        while(right < sArr.length){
            if(count % 2==0){
                reverse(sArr, left, right);
            }
            count++;
            left = right + 1;
            right = Math.min(left + k - 1,sArr.length-1);
        }
        return String.valueOf(sArr);
    }

    public void reverse(char[] c, int left, int right){
        while(left < right){
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
    }
}
