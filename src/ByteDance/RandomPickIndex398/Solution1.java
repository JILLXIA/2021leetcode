package ByteDance.RandomPickIndex398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution1 {
    HashMap<Integer, List<Integer>> map;
    Random rd;
    public Solution1(int[] nums) {
        rd = new Random();
        map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList());
                map.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int tmp = rd.nextInt(list.size());
        return list.get(tmp);
    }
}
