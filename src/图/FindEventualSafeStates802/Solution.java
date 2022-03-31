package 图.FindEventualSafeStates802;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where
 * graph[i] is an integer array of nodes adjacent to node i, meaning there
 * is an edge from node i to each node in graph[i].
 *
 * A node is a terminal node if there are no outgoing edges.
 * A node is a safe node if every possible path starting from
 * that node leads to a terminal node.
 *
 * Return an array containing all the safe nodes of the graph.
 * The answer should be sorted in ascending order.
 */
public class Solution {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		// reach a cycle from the node
		int N = graph.length;
		List<HashSet<Integer>> ngraph = new ArrayList<>(); // record the outcoming edge of every node
		List<HashSet<Integer>> rgraph = new ArrayList<>(); // record the incoming edge of every node

		for(int i = 0;i<N;i++){
			ngraph.add(new HashSet<>());
			rgraph.add(new HashSet<>());
		}

		// queue to record the safe node
		// array to record the safe node
		Deque<Integer> deque = new LinkedList<>();
		boolean[] safe = new boolean[N];

		for(int i = 0;i<N;i++){
			if(graph[i].length==0){
				// terminal node
				deque.offerLast(i);
				safe[i] = true;
			}
			for(int j:graph[i]){
				ngraph.get(i).add(j);
				rgraph.get(j).add(i);
			}
		}

		while(!deque.isEmpty()){
			int tmp = deque.pollFirst();
			for(int k:rgraph.get(tmp)){
				ngraph.get(k).remove(tmp);
				if(ngraph.get(k).size()==0){
					deque.offerLast(k);
					safe[k] = true;
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		for(int i = 0;i<safe.length;i++){
			if(safe[i]){
				result.add(i);
			}
		}
		return result;
	}
}
/**
 * Time Complexity: O(N + E), where N is the number of nodes in
 * the given graph, and E is the total number of edges.
 *
 * Space Complexity: O(N) in additional space complexity.
 */
