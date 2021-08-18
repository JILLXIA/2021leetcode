package 图.课程表207;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 你这个学期必须选修 numCourses 门课程，
 * 记为0到numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。
 * 先修课程按数组prerequisites 给出，
 * 其中prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；
 * 否则，返回 false 。
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 图的存储一定要采用邻接表；邻接矩阵会占用很多空间；邻接表可以用ArrayList来实现
        // 如果采用拓扑排序还要搞一个入度矩阵
        int[] indegree = new int[numCourses];
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 如果有入度为0 的把他加到deque里面
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0) {
                deque.offerLast(i);
            }
        }
        while(!deque.isEmpty()){
            int temp = deque.pollFirst();
            numCourses--;
            for(int i = 0;i<arr.get(temp).size();i++){
                // 邻接表最好不要变啊
                indegree[arr.get(temp).get(i)]--;
                if(indegree[arr.get(temp).get(i)]==0){
                    deque.offerLast(arr.get(temp).get(i));
                }
            }
        }
        return numCourses==0;
    }
}
