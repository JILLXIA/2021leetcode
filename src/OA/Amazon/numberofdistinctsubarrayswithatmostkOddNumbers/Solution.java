package OA.Amazon.numberofdistinctsubarrayswithatmostkOddNumbers;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distinctSubarraysAtMostKOdd(int[] nums, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < nums.length; i++) {
            int oddCount = 0;
            sb.setLength(0);

            for(int j = i; j < nums.length; j++) {
                if(isOdd(nums[j])) {
                    oddCount++;
                }

                if(oddCount > k)
                    break;

                sb.append("{").append(nums[j]).append("},");
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    private boolean isOdd(int x) {
        return (x & 1) == 1;
    }
}
