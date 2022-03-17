package 图.NumberOfProvinces547;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * There are n cities. Some of them are connected,
 * while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is
 * connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected
 * cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where
 * isConnected[i][j] = 1 if the ith city and the jth city
 * are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        Set<Integer> set = new HashSet<>(); // no need to use set to denote visited
        // use a boolean array just enough
        for(int i = 0;i < isConnected.length;i++){
            if(!set.contains(i)){
                Deque<Integer> deque = new LinkedList<>();
                deque.offerLast(i);
                set.add(i);
                while(!deque.isEmpty()){
                    int tmp = deque.pollFirst();
                    for(int j = 0;j<isConnected[tmp].length;j++){
                        if(!set.contains(j) && isConnected[tmp][j]==1){
                            set.add(j);
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
