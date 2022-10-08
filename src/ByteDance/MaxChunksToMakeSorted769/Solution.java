package ByteDance.MaxChunksToMakeSorted769;

/**
 * You are given an integer array arr of length n that
 * represents a permutation of the integers in the range [0, n - 1].
 *
 * We split arr into some number of chunks (i.e., partitions),
 * and individually sort each chunk. After concatenating them,
 * the result should equal the sorted array.
 *
 * Return the largest number of chunks we can make to sort the array.
 */
public class Solution {
    int[] minLeft;
    int[] minRight;
    int[] maxLeft;
    int[] maxRight;
    int result = 1;
    boolean flag = false;
    public int maxChunksToSorted(int[] arr) {
        // 4 (3,2,1,0)
        // if(min(arr1) > max(arr2)) cut = false
        // if(max(arr1) < min(arr))
        //      cutIndex + 1 dfs()
        // if(max(arr1) > min(arr))
        //      cutIndex + 1
        // 1 (0,2,3,4)  max(arr1) < min(arr)

        // minimum and maximum number in subarray
        // left right
        minLeft = new int[arr.length];
        minLeft[0] = arr[0];

        minRight = new int[arr.length];
        minRight[arr.length - 1] = arr[arr.length - 1];

        maxLeft = new int[arr.length];
        maxLeft[0] = arr[0];

        maxRight = new int[arr.length];
        maxRight[arr.length - 1] = arr[arr.length - 1];

        for(int i = 1;i<arr.length;i++){
            minLeft[i] = Math.min(minLeft[i-1], arr[i]);
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        for(int i = arr.length - 2;i>=0;i--){
            minRight[i] = Math.min(minRight[i+1], arr[i]);
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }
        dfs(arr,0,1);
        return result;
    }

    public void dfs(int[] arr, int start, int count){
        if(flag){
            return;
        }
        if(start==arr.length - 1){
            result = count;
            flag = true;
            return;
        }

        if(minLeft[start] > maxRight[start+1]){
            return;
        }

        if(maxLeft[start] > minRight[start+1]){
            for(int i = start+1;i<arr.length;i++){
                dfs(arr, i, count);
            }
            return;
        }
        dfs(arr, start + 1, count + 1);
    }
}