package labuladong.CourseSchedule207;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class Solution {
	boolean hasCycle = false;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] course = new List[numCourses];
		for(int i = 0;i<numCourses;i++){
			course[i] = new ArrayList<>();
		}
		for(int i = 0;i < prerequisites.length;i++){
			course[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		boolean[] isVisited = new boolean[numCourses];
		boolean[] onPath = new boolean[numCourses];// onPath表示当前路径，只有在当前路径上有点重合才能判断成环
		for(int i = 0;i<isVisited.length;i++){
			dfs(course, isVisited,onPath,i);
		}
		return hasCycle;
	}

	public void dfs(List<Integer>[] course, boolean[] isVisited, boolean[] onPath, int index){
		if(onPath[index]){
			// 已经遍历过了，说明有环
			hasCycle = true;
			return;
		}

		if(hasCycle || isVisited[index]){
			return;
		}
		isVisited[index] = true;
		onPath[index] = true;
		for(int i:course[index]){
			dfs(course, isVisited,onPath, i);
		}
		onPath[index] = false;
	}
}
