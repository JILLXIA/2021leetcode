package Amazon.RangeAddition370;

/**
 * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
 *
 * You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
 *
 * Return arr after applying all the updates.
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int[] update:updates){
            arr[update[0]] += update[2];
            if(update[1]+1 < length){
                arr[update[1]+1] -= update[2];
            }
        }
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }
}
