package ByteDance.MaxChunksToMakeSorted769;

public class Solution1 {
    public int maxChunksToSorted(int[] arr) {
        // if(max(arr1) < min(arr))
        //      cutIndex + 1 dfs()
        // if(max(arr1) > min(arr))
        //      cutIndex + 1
        // 1 (0,2,3,4)  max(arr1) < min(arr)

        int[] minRight = new int[arr.length];
        minRight[arr.length - 1] = arr[arr.length - 1];

        for(int i = arr.length - 2;i>=0;i--){
            minRight[i] = Math.min(minRight[i+1], arr[i]);
        }
        int maxLeft = arr[0];
        int count = 1;
        for(int i = 0;i<arr.length - 1;i++){
            maxLeft = Math.max(maxLeft,arr[i]);
            if(maxLeft > minRight[i+1]){
                continue;
            }
            count++;
        }
        return count;
    }
}
