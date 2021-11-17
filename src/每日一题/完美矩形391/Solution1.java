package 每日一题.完美矩形391;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public boolean isRectangleCover(int[][] rectangles) {
        // 计算每个小矩形面积是否等于大矩形面积
        // 看每个顶点出现的次数，如果最后出现一次的顶点不是四个，则说明不符合完美矩形
        int area = 0;
        Set<Integer> set = new HashSet<>();
        // 记录大矩形的左下角和右上角
        int a1 = Integer.MAX_VALUE, b1 = Integer.MAX_VALUE;
        int a2 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;

        for (int[] rec : rectangles) {
            // 小矩形的坐标
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];

            // 计算左下角
            if (x1 < a1 || y1 < b1) {
                a1 = x1;
                b1 = y1;
            }

            // 计算右上角
            if (x2 > a2 || y2 > b2) {
                a2 = x2;
                b2 = y2;
            }

            // 计算面积
            area += (x2 - x1) * (y2 - y1);

            // 记录每个顶点出现的次数
            record(set, x1, y1);
            record(set, x1, y2);
            record(set, x2, y1);
            record(set, x2, y2);
        }

        // 通过左下角和右上角坐标可以算出总面积
        int totalArea = (a2 - a1) * (b2 - b1);

        // 如果两个面积不相等，直接返回false
        if (area != totalArea) return false;

        // 四个为1的顶点正好是大矩形的四个顶点
        return set.size() == 4 && set.contains(key(a1, b1)) && set.contains(key(a1, b2)) && set.contains(key(a2, b1)) && set.contains(key(a2, b2));
    }

    private void record(Set<Integer> set, int x, int y) {
        // 记录顶点出现的次数，如果一个顶点出现偶数次，则移除
        int key = key(x, y);
        if (set.contains(key)) {
            set.remove(key);
        } else {
            set.add(key);
        }
    }

    private int key(int x, int y) {
        // 二维坐标转一维，方便比较
        // 100000007是随便取的一个大质数
        // 这里即使溢出了也没什么问题
        return x * 100000007 + y;
    }
}
