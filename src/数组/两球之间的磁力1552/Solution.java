package 数组.两球之间的磁力1552;

/**
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有n个空的篮子，第i个篮子的位置在position[i]，
 * Morty想把m个球放到这些篮子里，使得任意两球间最小磁力最大。
 *
 * 已知两个球如果分别位于x和y，那么它们之间的磁力为|x - y|。
 *
 * 给你一个整数数组position和一个整数m，请你返回最大化的最小磁力。
 */

/**
 * 两球的最小距离的最小值，是1；最小距离的最大值是 (最后位置的球坐标 - 最前位置的球坐标) / (球数-1)，这里需要先对position数组排序，那么易得最小球间距离的最大值为 (position[position.length - 1] - position[0]) / (m-1)
 * 有最小和最大，直觉想到二分法。 以二分的中间值，作为间距去摆放球。如果摆放的球数 >=m, 可认为需要增加球间距 （同时保存中间值作为候选答案）； 否则需要减少球间距。
 * 一点总结是， 当碰到求最大或最小值的时候，是否可转化为二分法。属于直觉和经验吧。
 */

import java.util.Arrays;

/**
 * 先猜一个答案，然后再判断它是否合理（二分法+贪心）
 * 看到有单调性的问题就想到二分查找
 */
public class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;//这里的左右区间是答案的左右区间，是用二分法猜答案
        int right = (position[position.length-1]-position[0])/(m-1);
        //int mid = (right+left)/2;
        int ans = -1;
        while(left<=right){//二分法的终止条件是相等
            int mid = (right+left)/2;//如果mid合理，小于等于mid的答案都合理，要向上找答案
            //如果mid不合理，就要吧mid缩小，此时还不确定ans
            //ans = position[mid]-position[left];
            if(!check(position,m,mid)){
                right = mid - 1;
            }else{
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] position, int m,int ans){
        int count = 1;
        int cur = position[0];
        for(int i = 1;i<position.length;i++){
            if(position[i]-cur>=ans){
                cur = position[i];
                count++;
            }
            if(count==m){
                return true;
            }
        }
        return false;
    }

//    public static void Main(String[] args){
//        Solution s = new Solution();
//        int[] arr = {5,4,3,2,1,100000000};
//        System.out.println(s.maxDistance(arr,2));
//
//    }
}
