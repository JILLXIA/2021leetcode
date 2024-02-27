package labuladong.CourseScheduleII210;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                deque.offerLast(i);
            }
        }

        while(!deque.isEmpty()) {
            int tmp = deque.pollFirst();
            result.add(tmp);

            for(int i = 0; i < graph.get(tmp).size(); i++) {
                indegree[graph.get(tmp).get(i)]--;
                if(indegree[graph.get(tmp).get(i)] == 0) {
                    deque.offerLast(graph.get(tmp).get(i));
                }
            }
        }

        if(result.size() != numCourses) {
            return new int[0];
        }

        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
