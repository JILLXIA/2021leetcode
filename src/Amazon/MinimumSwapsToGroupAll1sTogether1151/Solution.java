package Amazon.MinimumSwapsToGroupAll1sTogether1151;

/**
 * Given a binary array data,
 * return the minimum number of swaps required to group
 * all 1’s present in the array together in any place
 * in the array.
 */
public class Solution {
    public int minSwaps(int[] data) {
        int countOne = 0;
        for(int i = 0;i<data.length;i++){
            if(data[i]==1){
                countOne++;
            }
        }

        int result = 0;
        int countMinZero = 0;
        for(int i = 0;i<countOne;i++){
            if(data[i]==0){
                countMinZero++;
            }
        }
        result = countMinZero;

        for(int i = countOne;i<data.length;i++){
            if(data[i]==0){
                countMinZero++;
            }
            if(data[i-countOne]==0){
                countMinZero--;
            }
            result = Math.min(result,countMinZero);
        }
        return result;
    }
}
