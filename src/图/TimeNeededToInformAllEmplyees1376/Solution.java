package 图.TimeNeededToInformAllEmplyees1376;

import java.util.*;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1.
 * The head of the company is the one with headID.
 *
 * Each employee has one direct manager given in the manager array where manager[i]
 * is the direct manager of the i-th employee, manager[headID] = -1. Also,
 * it is guaranteed that the subordination relationships have a tree structure.
 *
 * The head of the company wants to inform all the company employees of an
 * urgent piece of news. He will inform his direct subordinates, and they will inform
 * their subordinates, and so on until all employees know about the urgent news.
 *
 * The i-th employee needs informTime[i] minutes to inform all of his direct
 * subordinates (i.e., After informTime[i] minutes, all his direct subordinates can
 * start spreading the news).
 *
 * Return the number of minutes needed to inform all the employees about the urgent news.
 */
// Time & Space: O(N)
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] managerArr = new List[n];
        for(int i = 0;i<n;i++){
            managerArr[i] = new ArrayList<>();
        }

        for(int i = 0;i< manager.length;i++){
            if(i != headID) {
                managerArr[manager[i]].add(i);
            }
        }

        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        // BFS
        Deque<Integer> deque = new LinkedList<>();
        memo[headID] = 0;
        deque.offerLast(headID);
        int result = 0;
        while(!deque.isEmpty()){
            int tmp = deque.pollFirst();
            for(int i = 0;i<managerArr[tmp].size();i++){
                deque.offerLast(managerArr[tmp].get(i));
                memo[managerArr[tmp].get(i)] = memo[tmp] + informTime[tmp];
                result = Math.max(result,memo[managerArr[tmp].get(i)]);
            }
        }
        return result;
    }
}
