package contest.WeeklyContest307.AmountOfTImeForBinaryTreeToBeInfected;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	public int amountOfTime(TreeNode root, int start) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerLast(root);
		map.put(root.val,new ArrayList<>());
		while(!deque.isEmpty()){
			TreeNode tmp = deque.pollFirst();
			TreeNode left = tmp.left;
			TreeNode right = tmp.right;
			if(left!=null){
				map.get(tmp.val).add(left.val);
				map.put(left.val,new ArrayList<>());
				map.get(left.val).add(tmp.val);
				deque.offerLast(left);
			}
			if(right!=null){
				map.get(tmp.val).add(right.val);
				map.put(right.val,new ArrayList<>());
				map.get(right.val).add(tmp.val);
				deque.offerLast(right);
			}
		}

		boolean[] isVisited = new boolean[100001];
		Deque<Integer> dequeArr = new LinkedList<>();
		dequeArr.offerLast(start);
		isVisited[start] = true;
		int result = -1;
		while(!dequeArr.isEmpty()){
			int size = dequeArr.size();
			result++;
			while(!dequeArr.isEmpty() && size > 0){
				ArrayList<Integer> tmp = map.get(dequeArr.pollFirst());
				for(int i:tmp){
					if(!isVisited[i]) {
						dequeArr.offerLast(i);
						isVisited[i] = true;
					}
				}
				size--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root0 = new TreeNode(1);
		TreeNode root1 = new TreeNode(5);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(10);
		TreeNode root5 = new TreeNode(6);
		TreeNode root6 = new TreeNode(9);
		TreeNode root7 = new TreeNode(2);
		root0.left = root1;
		root0.right = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root3.right = root7;
		System.out.println(s.amountOfTime(root0,3));
	}
}
