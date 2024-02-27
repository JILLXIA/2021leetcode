package labuladong.AdvantageShuffle870;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Greedy, two pointer
public class Solution1 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        // 大的跟大的比，比得过就放在nums2同样的位置，比不过就换成最小的
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for(int i = 0; i < nums2.length; i++){
            priorityQueue.add(new int[]{i, nums2[i]});
        }

        int[] result = new int[nums1.length];

        int left = 0;
        int right = nums1.length - 1;

        while(left <= right){
            int[] tmp = priorityQueue.poll();
            int index = tmp[0];
            int value = tmp[1];
            if(nums1[right] > value) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }
        }
        return result;
    }
}
