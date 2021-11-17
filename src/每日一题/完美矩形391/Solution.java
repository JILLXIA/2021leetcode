package 每日一题.完美矩形391;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi]
 * 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 *
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 */
public class Solution {

    // 吗的 不知道哪里有bug
    public boolean isRectangleCover(int[][] rectangles) {
        // 找出每个举行的四个定点，四个角只出现一次，其他内部的出现偶数次则符合题意
        // 难点在于如何存储一个二维的key,利用大质数，二维转一维
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymax = Integer.MIN_VALUE;
        int area = 0;
        for(int i = 0;i<rectangles.length;i++){
            if(rectangles[i][0]<xmin || rectangles[i][1]<ymin){
                xmin = rectangles[i][0];
                ymin = rectangles[i][1];
            }

            if(rectangles[i][2]>xmax || rectangles[i][3]>ymax){
                xmax = rectangles[i][2];
                ymax = rectangles[i][3];
            }
            xmin = Math.min(rectangles[i][0],xmin);
            ymin = Math.min(rectangles[i][1],ymin);
            xmax = Math.max(rectangles[i][2],xmax);
            ymax = Math.max(rectangles[i][1],ymax);

            // map记录所有的四个顶点
            if(map.containsKey(rectangles[i][0]*100000007+rectangles[i][1])){
                map.remove(rectangles[i][0]*100000007+rectangles[i][1]);
            }else {
                map.put(rectangles[i][0]*100000007+rectangles[i][1],1);
            }

            if(map.containsKey(rectangles[i][2]*100000007+rectangles[i][3])){
                map.remove(rectangles[i][2]*100000007+rectangles[i][3]);
            }else {
                map.put(rectangles[i][2]*100000007+rectangles[i][3],1);
            }

            area += (rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);

        }

        int tmp1 = xmin*100000007+ymin;
        int tmp4 = xmax*100000007+ymax;


        return map.containsKey(tmp1)&&map.containsKey(tmp4);
    }
}
