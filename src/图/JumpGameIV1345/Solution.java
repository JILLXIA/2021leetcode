package 图.JumpGameIV1345;

import java.util.*;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 */
public class Solution {
    public int minJumps(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        // use ArrayList to improve the search rate
        Map<Integer, ArrayList<Integer>> map =  new HashMap<>();
        for(int i = 0;i < arr.length; i++){
            map.computeIfAbsent(arr[i],x -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[arr.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        visited[0] = true;
        int count = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            count++;
            while(!deque.isEmpty() && size > 0){
                int tmpIndex = deque.pollFirst();
                ArrayList<Integer> nextSet = map.get(arr[tmpIndex]);
                if(tmpIndex - 1 >= 0 && !nextSet.contains(tmpIndex - 1)){
                    nextSet.add(tmpIndex - 1);
                }
                if(tmpIndex + 1 < arr.length && !nextSet.contains(tmpIndex + 1)){
                    nextSet.add(tmpIndex + 1);
                }
                for(int index: nextSet){
                    if(index==arr.length-1){
                        // the end of the arr
                        return count;
                    }
                    if(!visited[index]){
                        // visited flag 在添加的时候设置！！！
                        visited[index] = true;
                        deque.offerLast(index);
                    }
                }
                nextSet.clear();
                size--;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.minJumps(new int[]{7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,11}));
    }
}
