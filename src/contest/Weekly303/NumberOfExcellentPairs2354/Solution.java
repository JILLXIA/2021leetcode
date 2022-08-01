package contest.Weekly303.NumberOfExcellentPairs2354;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	long result = 0;
	List<Integer> path = new ArrayList<>();
	public long countExcellentPairs(int[] nums, int k) {
		// remove the repeat number in nums
		boolean[] visited = new boolean[1000000001];
		List<Integer> numArr = new ArrayList<>();
		for(int i = 0;i<nums.length;i++){
			if(!visited[nums[i]]){
				numArr.add(nums[i]);
				visited[nums[i]] = true;
			}
		}
		// Collections.sort(numArr);
		backtrace(numArr,k,0);
		return result;
	}

	public void backtrace(List<Integer> numArr, int k, int start){
		if(path.size()==2){
			if(Integer.bitCount(path.get(0) | path.get(1)) +
					Integer.bitCount(path.get(0) & path.get(1)) >= k){
				if(path.get(0)==path.get(1)){
					result += 1;
				}else{
					result += 2;
				}
			}
			return;
		}

		for(int i = start;i<numArr.size();i++){
			path.add(numArr.get(i));
			backtrace(numArr,k,i);
			path.remove(path.size()-1);
		}
	}

	public int countNumber1(int num){
		int count = 0;
		while(num!=0){
			num = num & (num-1);
			count++;
		}
		return count;
	}
}
