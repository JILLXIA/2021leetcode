package Amazon.MaximumUnitsOnATruck1710;

public class Solution1 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // bucket sort
        // 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
        int[] bucket = new int[1001];
        for(int i = 0;i<boxTypes.length;i++){
            bucket[boxTypes[i][1]] +=  boxTypes[i][0];
        }

        int result = 0;
        for(int i = 1000;i>=1;i--){
            if(bucket[i] > truckSize){
                result += truckSize * i;
                break;
            }
            result += bucket[i] * i;
            truckSize -= bucket[i];
        }
        return result;
    }
}
