package OA.Citadel.VisitingCities;

public class Solution {
    public int[] visitingCities(int[] red, int[] blue, int blueCost){
        int[] dp = new int[red.length+1];
        int type = 1;// 1是红车 -1是蓝车
        for(int i = 1;i<dp.length;i++){
            int costRed = dp[i-1] + red[i-1];
            int costBlue = dp[i-1] + blue[i-1];
            if(type==1){
                costBlue += blueCost;
            }
            if(costRed < costBlue){
                type = 1;
            } else {
                type = -1;
            }
            dp[i] = Math.min(costRed,costBlue);
        }
        return dp;
    }

    public int[] visitingCitiesNew(int[] red, int[] blue, int blueCost){
        int[] dp_red = new int[red.length+1];
        int[] dp_blue = new int[red.length+1];
        int[] dp = new int[red.length+1];
        dp_red[1] = red[0];
        dp_blue[1] = blueCost + blue[0];
        dp[1] = Math.min(dp_red[1],dp_blue[1]);
        for(int i = 2;i<dp.length;i++){
            dp_red[i] = Math.min(dp_red[i-1]+red[i-1],dp_blue[i-1]+red[i-1]);
            dp_blue[i] = Math.min(dp_blue[i-1]+blue[i-1],dp_red[i-1]+blueCost+blue[i-1]);
            dp[i] = Math.min(dp_red[i],dp_blue[i]);
        }
        return dp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.visitingCitiesNew(new int[]{2,3,4},new int[]{3,1,1},2);
        for(int i:tmp){
            System.out.println(i);
        }
    }
}

/**
 * 因此状态转移大致应该是
 * onredlinecost\[i\]= min(onredlinecost[i-1] + red,
 * onbluelinecost[i-1] + red);
 *
 * onbluelinecost\[i\] = min(onbluelinecost[i-1] + blue,
 * onredlinecost[i-1] + blue + bluecost)
 */