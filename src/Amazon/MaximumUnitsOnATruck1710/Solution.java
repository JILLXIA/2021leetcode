package Amazon.MaximumUnitsOnATruck1710;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes,
 * where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize,
 * which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck as long as the number of boxes
 * does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 */
public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        });

        int result = 0;
        for(int i = 0;i< boxTypes.length;i++){
            if(truckSize >= boxTypes[i][0]){
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                if(truckSize <= 0){
                    break;
                }
                result += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        return result;
    }
}
