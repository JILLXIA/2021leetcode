package OA.Amazon.commonPrefix;

public class Solution {
    public int commonPrefix(String s){
        int result = s.length();
        char[] cArray = s.toCharArray();

        for(int i = 1;i<cArray.length;i++){
            int index = 0;
            while(index + i <cArray.length && cArray[index+i]==cArray[index]){
                index++;
            }
            result += index;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.commonPrefix("abcabc"));
    }
}
