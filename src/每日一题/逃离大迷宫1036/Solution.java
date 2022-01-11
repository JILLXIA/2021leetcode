package 每日一题.逃离大迷宫1036;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为(x, y) 。
 *
 * 现在从源方格source = [sx, sy]开始出发，
 * 意图赶往目标方格target = [tx, ty] 。数组 blocked 是封锁的方格列表，
 * 其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，
 * 只要该方格 不 在给出的封锁列表blocked上。同时，不允许走出网格。
 *
 * 只有在可以通过一系列的移动从源方格source 到达目标方格
 * target 时才返回true。否则，返回 false。
 */
public class Solution {

    public static int BLOCK = 1;

    public static int OVER = 2;

    public static int PASS = 3;

    public int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        if(n<=1){
            return true;
        }
        // 最大面积
        int max = n*(n-1)/2;

        // 存储block里面的点
        Set<Integer> blockedSet = new HashSet<>();
        for(int i = 0;i<n;i++){
            blockedSet.add(convert(blocked[i][0],blocked[i][1]));
        }


        int result = bfs(blockedSet,source,target,max);
        if(result == PASS) {
            return true;
        } else if(result == BLOCK) {
            return false;
        }else {
            return bfs(blockedSet,target,source,max) != BLOCK;
        }
    }

    public int bfs(Set<Integer> blockedSet, int[] point,int[] target,int max){
        // 设置一个遍历队列
        Set<Integer> visited = new HashSet<>();
        visited.add(convert(point[0],point[1]));
        // 使用队列
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(point);

        while(!deque.isEmpty()){
            int[] tmp = deque.pollFirst();

            for(int i = 0;i< dir.length;i++){
                // 符合区间的加入列表
                // 加入的时候就要判断结果，poll出来的时候只是为了获取更多的点，早点判断结果可以剪枝
                int tempx = tmp[0]+dir[i][0];
                int tempy = tmp[1]+dir[i][1];
                int convertTmp = convert(tempx,tempy);
                if(tempx >= 0 && tempx < 1000000 && tempy >=0 && tempy < 1000000 &&
                !blockedSet.contains(convertTmp) && !visited.contains(convertTmp)) {
                    if(tempx==target[0] && tempy==target[1]){
                        return PASS;
                    }

                    visited.add(convertTmp);
                    if(visited.size() > max) {
                        return OVER;
                    }
                    deque.offerLast(new int[]{tempx, tempy});
                }
            }
        }

        return BLOCK;
    }

    public int convert(int x,int y){
        return x * 1000007 + y;
    }
}
