package 图.NumberOfProvinces547;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution1 {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        boolean[] visited = new boolean[isConnected.length];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i < isConnected.length;i++){
            if(!visited[i]){
                deque.offerLast(i);
                visited[i] = true;
                while(!deque.isEmpty()){
                    int tmp = deque.pollFirst();
                    for(int j = 0;j<isConnected[tmp].length;j++){
                        if(!visited[j] && isConnected[tmp][j]==1){
                            visited[j] = true;
                            deque.offerLast(j);
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }
}
