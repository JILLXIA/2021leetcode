package 图.课程表II210;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 现在你总共有 n 门课需要选，记为0到n-1。
 *
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，
 * 你需要先完成课程1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 邻接表来存储图
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0;i< prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;// 统计入度
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0;i< indegree.length;i++){
            if(indegree[i]==0){
                deque.offerLast(i);
            }
        }

        while(!deque.isEmpty()){
            int temp = deque.pollFirst();
            result.add(temp);
            for(int i = 0;i<arr.get(temp).size();i++){
                indegree[arr.get(temp).get(i)]--;
                if(indegree[arr.get(temp).get(i)]==0){
                    deque.offerLast(arr.get(temp).get(i));
                }
            }
        }
        if(result.size()==numCourses){
            return result.stream().mapToInt(Integer::intValue).toArray();
        }else {
            return new int[0];
        }
    }
}
