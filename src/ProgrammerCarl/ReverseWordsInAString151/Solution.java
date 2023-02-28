package ProgrammerCarl.ReverseWordsInAString151;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order
 * concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or
 * multiple spaces between two words. The returned string
 * should only have a single space separating the words. Do not include any extra spaces.
 */

// it will use the extra space
public class Solution {
    public String reverseWords(String s) {
        String[] sList = s.split(" ");

        int left = 0;
        int right = sList.length - 1;

        while(left < right){
            while(left < right && sList[left].equals("")){
                left++;
            }

            while(left < right && sList[right].equals("")){
                right--;
            }

            if(left == right){
                break;
            }

            String tmp = sList[left];
            sList[left] = sList[right];
            sList[right] = tmp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < sList.length;i++){
            if(!sList[i].equals("")){
                sb.append(sList[i]);
                sb.append(" ");
            }
        }

        return sb.substring(0,sb.length() - 1);
    }
}
