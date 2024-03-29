package labuladong.CourseSchedule207;
// BFS 也可以解决

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 构建邻接表
 * 2. 构建一个indegree数组记录每个节点的入度， indegree[i] 记录节点i的入度
 * 3. 对BFS队列进行初始化，将入度为0的节点首次装入队列
 * 4. 开始执行BFS循环，不断弹出队列中的节点，减少相邻节点的入度，并且将入度为0的节点加入队列
 * 5. 最终如果所有节点都被遍历过说明不成环
 */
public class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 拓扑排序
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

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                deque.offerLast(i);
            }
        }

        while(!deque.isEmpty()) {
            int tmp = deque.pollFirst();
            numCourses--;
            for(int i = 0; i < graph.get(tmp).size();i++) {
                indegree[graph.get(tmp).get(i)]--;
                if(indegree[graph.get(tmp).get(i)] == 0) {
                    deque.offerLast(graph.get(tmp).get(i));
                }
            }
        }
        return numCourses == 0;
    }
}
