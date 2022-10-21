package ByteDance.ThreeEqualParts927;

/**
 * You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.
 *
 * If it is possible, return any [i, j] with i + 1 < j, such that:
 *
 * arr[0], arr[1], ..., arr[i] is the first part,
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
 * All three parts have equal binary values.
 * If it is not possible, return [-1, -1].
 *
 * Note that the entire part is used when considering what binary value it represents.
 * For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 */

public class Solution {
    public int[] threeEqualParts(int[] arr) {
        if(arr.length < 3){
            return new int[]{-1,-1};
        }
        // count the number of 1
        // int each = count / 3
        // count back -> front

        // [1,0,1,0,1]   1
        // prefix zero
        // head pointer, rear pointer compare same item

        // pointer start of the second item
        // [0,0,0,0,0,0,0]

        // return end of the first part and start of the third part
        int countOne = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==1){
                countOne++;
            }
        }
        if(countOne % 3 != 0){
            return new int[]{-1,-1};
        }
        if(countOne == 0){
            // edge case
            return new int[]{0,arr.length - 1};
        }

        int eachOne = countOne / 3;

        int thirdOneStart = arr.length;
        int countThirdOne = 0;
        while(countThirdOne < eachOne){
            thirdOneStart--;
            if(arr[thirdOneStart]==1){
                countThirdOne++;
            }
        }

        int firstOneStart = 0;
        while(arr[firstOneStart]==0){
            firstOneStart++;
        }

        // check the first part and third part
        int thirdStart1 = thirdOneStart;
        while(thirdStart1 < arr.length && arr[firstOneStart] == arr[thirdStart1]){
            thirdStart1++;
            firstOneStart++;
        }

        if(thirdStart1 < arr.length){
            return new int[]{-1,-1};
        }

        int secondOneStart = firstOneStart;
        while(arr[secondOneStart]==0){
            secondOneStart++;
        }
        // check the first part and third part
        int thirdStart2 = thirdOneStart;
        while(thirdStart2 < arr.length && arr[secondOneStart] == arr[thirdStart2]){
            thirdStart2++;
            secondOneStart++;
        }
        if(thirdStart2 < arr.length){
            return new int[]{-1,-1};
        }
        return new int[]{firstOneStart-1,secondOneStart};
    }
}
