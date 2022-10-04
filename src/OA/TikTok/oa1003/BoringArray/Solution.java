package OA.TikTok.oa1003.BoringArray;

import java.util.Arrays;

public class Solution {
    public boolean boringArray(String s1, String s2){
        String[] sArr1 = s1.split(" ");
        String[] sArr2 = s2.split(" ");
        if(sArr1.length != sArr2.length){
            return false;
        }
        int[] arr1 = new int[sArr1.length];
        int[] arr2 = new int[sArr2.length];
        for(int i = 0;i<arr1.length;i++){
            arr1[i] = Integer.parseInt(sArr1[i]);
            arr2[i] = Integer.parseInt(sArr2[i]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i = 0;i<arr1.length;i++){
            if(arr1[i]==arr2[i] || arr1[i] + 1==arr2[i]){
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.boringArray("4 2 3 4 0","1 2 3 4 5"));
    }
}
