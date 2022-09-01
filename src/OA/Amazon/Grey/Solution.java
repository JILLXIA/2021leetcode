package OA.Amazon.Grey;

import java.util.List;

public class Solution {
    public int findGreyness(List<String> grid){
        int n = grid.size();
        int m = grid.get(0).length();
        int[] blackPixelsn = new int[n];
        int[] blackPixelsm = new int[m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid.get(i).charAt(j)=='1'){
                    blackPixelsn[i]++;
                    blackPixelsm[j]++;
                }
            }
        }

        int result = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                result = Math.max(result, Math.abs(blackPixelsn[i] + blackPixelsm[j] - (n-blackPixelsn[i])-(m-blackPixelsm[j])));
            }
        }
        return result;
    }
}
