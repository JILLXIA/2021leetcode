package labuladong.PathWithMaximumProbability1514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an undirected weighted graph of n nodes (0-indexed),
 * represented by an edge list where edges[i] = [a, b]
 * is an undirected edge connecting the nodes a and b with a probability of
 * success of traversing that edge succProb[i].
 *
 * Given two nodes start and end, find the path with the maximum probability
 * of success to go from start to end and return its success probability.
 *
 * If there is no path from start to end, return 0. Your answer will
 * be accepted if it differs from the correct answer by at most 1e-5.
 */
public class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		ArrayList<State>[] graph = new ArrayList[n];
		for(int i = 0;i<n;i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 0;i< edges.length;i++){
			graph[edges[i][0]].add(new State(edges[i][1],succProb[i]));
			graph[edges[i][1]].add(new State(edges[i][0],succProb[i]));
		}

		double[] maxProbability = new double[n];
		Arrays.fill(maxProbability,-1);

		// double 排序时的特殊用法
		PriorityQueue<State> pq = new PriorityQueue<>((a,b) -> Double.compare(b.getCurrProbability(),a.getCurrProbability()));
		pq.add(new State(start,1));
		maxProbability[start] = 1;

		double result = 0;
		while(!pq.isEmpty()){
			State tmpState = pq.poll();
			int curId = tmpState.getCurrId();
			double curPro = tmpState.getCurrProbability();

			if(curId==end){
				result  = Math.max(result, curPro);
				continue;
			}

			if(curPro < maxProbability[curId]){
				continue;
			}

			for(State state:graph[curId]){
				double nextPro = state.getCurrProbability() * curPro;
				if(maxProbability[state.getCurrId()] < nextPro){
					maxProbability[state.getCurrId()] = nextPro;
					pq.add(new State(state.getCurrId(),nextPro));
				}
			}
		}
		return result;
	}

}

class State{
	private int currId;
	private double currProbability;

	public State(int currId, double currProbability) {
		this.currId = currId;
		this.currProbability = currProbability;
	}

	public int getCurrId() {
		return currId;
	}

	public void setCurrId(int currId) {
		this.currId = currId;
	}

	public double getCurrProbability() {
		return currProbability;
	}

	public void setCurrProbability(double currProbability) {
		this.currProbability = currProbability;
	}
}