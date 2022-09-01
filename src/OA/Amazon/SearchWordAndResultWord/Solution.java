package OA.Amazon.SearchWordAndResultWord;

public class Solution {
    public int searchAndResultWord(String searchWord, String resultWord){
        int index1 = 0;
        int index2 = 0;

        while(index1 < searchWord.length() && index2 < resultWord.length()){
            if(searchWord.charAt(index1)==resultWord.charAt(index2)){
                index1++;
                index2++;
            } else {
                index1++;
            }
        }
        return resultWord.length() - index2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchAndResultWord("armaze","amazon"));
        System.out.println(s.searchAndResultWord("armaze","ama"));
        System.out.println(s.searchAndResultWord("rmaze","mazhwed"));
    }
}
