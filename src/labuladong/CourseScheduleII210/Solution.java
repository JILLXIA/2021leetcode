package labuladong.CourseScheduleII210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class Solution {
	boolean hasCycle = false;
	boolean[] isVisited, onPath;
	List<Integer>[] course;
	List<Integer> postOrder = new ArrayList<>();
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		isVisited = new boolean[numCourses];
		onPath = new boolean[numCourses];
		course = new List[numCourses];
		for(int i = 0;i<numCourses;i++){
			course[i] = new ArrayList<>();
		}

		for(int i = 0;i< prerequisites.length;i++){
			course[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for(int i = 0;i<numCourses;i++){
			dfs(i);
		}

		Collections.reverse(postOrder);// 后序遍历反转

		if(hasCycle){
			return new int[]{};
		}

		int[] result = new int[numCourses];
		for(int i = 0;i<numCourses;i++){
			result[i] = postOrder.get(i);
		}
		return result;
	}

	public void dfs(int index){
		if(onPath[index]){
			hasCycle = true;
			return;
		}
		if(hasCycle || isVisited[index]){
			return ;
		}

		isVisited[index] = true;
		onPath[index] = true;

		for(int i:course[index]){
			dfs(i);
		}
		onPath[index] = false;
		postOrder.add(index);
	}
}
