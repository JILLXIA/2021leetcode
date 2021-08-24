package 每日一题.省份数量547;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 尝试用bfs实现
 */
public class Solution1 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        for(int i = 0;i< isVisited.length;i++){
            if(!isVisited[i]){
                count++;
                // 没有被访问到的时候，压入队列
                deque.offerLast(i);
                isVisited[i] = true;
                while(!deque.isEmpty()){
                    int temp = deque.pollFirst();
                    for(int j = 0;j< isVisited.length;j++){
                        if(isConnected[temp][j]==1 && !isVisited[j]){
                            deque.offerLast(j);
                            isVisited[j] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
