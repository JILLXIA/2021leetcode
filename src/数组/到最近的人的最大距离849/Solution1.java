package 数组.到最近的人的最大距离849;

import java.util.Arrays;

/**
 * 动态规划
 *
 * 令 left[i] 为座位 i 到坐在 i 左边的人的最近距离。
 * 同理 right[i] 为座位 i 到坐在 i 右边的人的最近距离。
 * 那么该座位到最近的人的距离为 min(left[i], right[i])。
 *
 * 如果 i 左边的位置是空的，那么 left[i] = left[i - 1] + 1；
 * 如果i位置已经有人做了 left[i] = 0。right[i] 的计算方法类似。
 *
 * 左边右边要分别开辟两个数组
 */
public class Solution1 {
    public int maxDistToClosest(int[] seats) {
        int length = seats.length;
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        Arrays.fill(arr1,length);//要初始化成最大值
        Arrays.fill(arr2,length);//初始化数组的办法

        for(int i = 0;i<length;i++){
            if(seats[i]==1){
                arr1[i] = 0;
            }else if(i>0){
                //如果第一个座位是空的，那她距离左边位置的距离应该是无限大的，只需要取右边的距离
                //所以初始值应该是length
                arr1[i] = arr1[i-1] + 1;
            }
        }

        for(int i = length-1;i>=0;i--){
            if(seats[i]==1){
                arr2[i] = 0;
            }else if(i<length-1){
                arr2[i] = arr2[i+1]+1;
            }
        }
        int result = 0;
        for(int i = 0;i<length;i++){
            result = Math.max(result,Math.min(arr1[i],arr2[i]));
        }

        return result;
    }
}
