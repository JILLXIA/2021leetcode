package labuladong.NetworkDelayTime743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		int[] minDist = new int[n+1];
		Arrays.fill(minDist,Integer.MAX_VALUE);
		minDist[k] = 0;

		PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
			@Override
			public int compare(State o1, State o2) {
				return o1.getCurDist()-o2.getCurDist();
			}
		});

		ArrayList<State>[] graph = new ArrayList[n+1];
		for(int i = 0;i<n+1;i++){
			graph[i] = new ArrayList<State>();
		}

		for(int[] time:times){
			graph[time[0]].add(new State(time[1],time[2]));
		}

		pq.add(new State(k,0));

		while(!pq.isEmpty()){
			State tmpCur = pq.poll();
			int curNodeId = tmpCur.getCurId();
			int curNodeDist = tmpCur.getCurDist();

			if(curNodeDist > minDist[curNodeId]){
				continue;
			}

			for(State state:graph[curNodeId]){
				int nextId = state.getCurId();
				int nextDist = tmpCur.getCurDist() + state.getCurDist();
				if(nextDist < minDist[nextId]){
					pq.add(new State(nextId,nextDist));
					minDist[nextId] = nextDist;
				}
			}
		}
		int result = 0;
		for(int i = 1;i<n+1;i++){
			if(minDist[i]==Integer.MAX_VALUE){
				return -1;
			}
			result = Math.max(result,minDist[i]);
		}
		return result;
	}

//	public static void main(String[] args) {
//		Solution s = new Solution();
//		System.out.println(s.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
//	}
}

class State{
	int curId;
	int curDist;

	public State(int curId, int curDist) {
		this.curId = curId;
		this.curDist = curDist;
	}

	public int getCurId() {
		return curId;
	}

	public void setCurId(int curId) {
		this.curId = curId;
	}

	public int getCurDist() {
		return curDist;
	}

	public void setCurDist(int curDist) {
		this.curDist = curDist;
	}
}