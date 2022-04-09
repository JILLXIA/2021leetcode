package 图.JumpGameIII1306;

/**
 * Given an array of non-negative integers arr,
 * you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i],
 * check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 */
public class Solution {
    public boolean canReach(int[] arr, int start) {
        // every node at most visited once
        boolean[] visited = new boolean[arr.length]; // maybe we don't need to use the array to represent visited flag, we can use the arr itself

        return dfs(arr,visited,start);
    }

    /**
     * Time O(N), as each number will be flipper at most once.
     * Space O(N) for recursion.
     * @param arr
     * @param visited
     * @param current
     * @return
     */
    public boolean dfs(int[] arr, boolean[] visited, int current){
        // current in the range of (0, arr.length)
        if(current < 0 || current >= arr.length){
            return false;
        }

        if(visited[current]){
            return false;
        }

        if(arr[current]==0){
            return true;
        }

        visited[current] = true;
        return dfs(arr, visited, current + arr[current]) || dfs(arr, visited, current - arr[current]);
    }
}
