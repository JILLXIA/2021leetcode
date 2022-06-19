package labuladong.CourseScheduleII210;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] course = new List[numCourses];
		for(int i = 0;i<numCourses;i++){
			course[i] = new ArrayList<>();
		}
		int[] indegree = new int[numCourses];
		for(int i = 0;i< prerequisites.length;i++){
			course[prerequisites[i][1]].add(prerequisites[i][0]);
			indegree[prerequisites[i][0]]++;
		}

		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0;i< indegree.length;i++){
			if(indegree[i]==0){
				deque.offerLast(i);
			}
		}
		List<Integer> result = new ArrayList<>();
		int number = 0;
		while(!deque.isEmpty()){
			int tmp = deque.pollFirst();
			number++;
			result.add(tmp);
			for(int i:course[tmp]){
				indegree[i]--;
				if(indegree[i]==0){
					deque.offerLast(i);
				}
			}
		}

		if(number != numCourses){
			return new int[]{};
		}else {
			int[] answer = new int[numCourses];
			for(int i = 0;i<numCourses;i++){
				answer[i] = result.get(i);
			}
			return answer;
		}
	}
}
