package 数组.到最近的人的最大距离849;

/**
 * 给你一个数组seats 表示一排座位，
 * 其中 seats[i] = 1 代表有人坐在第 i 个座位上，
 * seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 */
//二分法结果反推
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = 1;
        int right = seats.length-1;
        int mid = (left+right)/2;

        int result = mid;
        while(left<=right){
            if(isRight(seats,mid)){
                left = mid+1;
                result = mid;
            }else{
                right = mid-1;
            }
            mid = (left+right)/2;
        }

        return result;
    }

    public static boolean isRight(int[] seats, int ans){
        //seat前后多加ans
        int i = -ans+1;
        int j = ans-1;
        int pos = 0;

        int sum = 0;

        int templeft = 0;
        int tempright = j;

        for(int k  = templeft;k<=tempright;k++){
            sum+=seats[k];
        }

        while(pos<seats.length){
            if(seats[pos]!=1 && sum==0){
                return true;
            }
            //更新sum的值
            if(i>=0){
                sum = sum-seats[i];
            }
            pos++;
            i++;
            j++;
            if(j<=seats.length-1){
                sum = sum+seats[j];
            }

        }
        return false;
    }

    public static void main(String[] args){
        Solution s  = new Solution();
        int[] arr = {1,0,0,1};
        System.out.println(s.maxDistToClosest(arr));
    }
    /**
     * 麻了 这题的题解都不是这么做的
     */
}
