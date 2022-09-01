package OA.Amazon.MoveLocations;

import java.util.HashSet;

public class Solution {
    public int[] moveLocations(int[] locations, int[] movedFrom, int[] movedTo){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<locations.length;i++){
            set.add(locations[i]);
        }

        for(int i = 0;i<movedTo.length;i++){
            set.remove(movedFrom[i]);
            set.add(movedTo[i]);
        }
        int[] result = new int[locations.length];
        int count = 0;
        for(int item:set){
            result[count] = item;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.moveLocations(new int[]{1,7,6,8},new int[]{1,7,2},new int[]{2,9,5});
        for(int i = 0;i<tmp.length;i++){
            System.out.println(tmp[i]);
        }
    }
}
