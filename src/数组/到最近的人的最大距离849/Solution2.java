package 数组.到最近的人的最大距离849;

/**
 * 假设两个人之间有 K 个空座位，则存在座位到最近的人的距离为 (K+1) / 2。
 *
 * 对于边缘的座位，它们的一侧没有人，那么认为它们到该侧最近的人的距离为 K。
 */
public class Solution2 {
    public int maxDistToClosest(int[] seats) {
        //先找到边缘座位的人，再计算两边
        int left = 0;
        int right = seats.length-1;

        int ans = 0;
        int count = 0;
        for(;left<seats.length-1;left++){
            if(seats[left]==1){
                break;
            }
        }
        ans = Math.max(0,left);//如果坐在最左边人的左侧，最近的人的最大距离为left

        for(;right>=0;right--){
            if(seats[right]==1){
                break;
            }
        }
        ans = Math.max(ans,seats.length-1-right);//如果坐在最右边的人的右侧，最近的人的最大距离为seats.length-1-right

        //最后遍历中间
        for(int i = left;i<=right;i++){
            if(seats[i]==1){
                ans = Math.max(ans,(count+1)/2);
                count = 0;
            }else{
                count++;
            }
        }
        return ans;
    }
}
