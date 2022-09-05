package OA.Amazon.divideBy4Or2;

import java.util.ArrayList;

public class Solution {
    public int[] divideBy4Or2(int[] num){
        int[] result = new int[num.length];

        for(int i = 0;i<num.length;i++){
            if(num[i] % 2!=0){
                result[i] = 0;
            } else {
                int tmp = num[i] / 4;
                result[i] = tmp * 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.divideBy4Or2(new int[]{4,5,6});
        for(int i = 0;i<tmp.length;i++){
            System.out.println(tmp[i]);
        }
    }
}
