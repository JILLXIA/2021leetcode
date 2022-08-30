package OA.Citadel.SprintTrainingLC370;

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int[] update:updates){
            arr[update[0]] += update[2];
            if(update[1] + 1 < length){
                arr[update[1]+1] -= update[2];
            }
        }
        int[] result = new int[length];
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            result[i] = sum;
        }
        return result;
    }
}
