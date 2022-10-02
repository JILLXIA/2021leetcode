package Google.LongestAbsoluteFilePath388;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Suppose we have a file system that stores both files and directories.
 * An example of one system is represented in the following picture:
 *
 * Here, we have dir as the only directory in the root.
 * dir contains two subdirectories, subdir1 and subdir2.
 * subdir1 contains a file file1.ext and subdirectory subsubdir1.
 * subdir2 contains a subdirectory subsubdir2,
 * which contains a file file2.ext.
 *
 * In text form, it looks like this
 * (with ⟶ representing the tab character):
 */

// 和71题类似
// 采用stack来解题
public class Solution {
    public int lengthLongestPath(String input) {
       String[] inputArr = input.split("\n");
       Deque<Integer> deque = new LinkedList<>();
       deque.offerLast(0);//dump node
       int result = 0;
       for(int i = 0;i< inputArr.length;i++){
           int tabNumber = countTab(inputArr[i]);
           while(tabNumber < deque.size()-1){
               deque.pollLast();
           }
           if(inputArr[i].contains(".")){
               if(tabNumber!=0){
                   result = Math.max(result, inputArr[i].length() + 1 + deque.peekLast() - tabNumber);
               } else{
                   result = Math.max(result, inputArr[i].length() + deque.peekLast() - tabNumber);
               }

           } else {
               if(tabNumber!=0){
                   deque.offerLast(inputArr[i].length() + 1 + deque.peekLast() - tabNumber);
               } else {
                   deque.offerLast(inputArr[i].length() + deque.peekLast() - tabNumber);
               }
           }
       }
       return result;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
//    }
    public int countTab(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='\t'){
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
