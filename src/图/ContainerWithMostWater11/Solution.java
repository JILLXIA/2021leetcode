package 图.ContainerWithMostWater11;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0)
 * and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class Solution {
	public int maxArea(int[] height) {
		int startIndex = 0;
		int endIndex = height.length-1;
		int result = 0;
		//Move the shorter height among 2 pointers to the next position.
		while(startIndex<endIndex && startIndex< height.length && endIndex >= 0){
			result = Math.max(Math.min(height[startIndex],height[endIndex]) * (endIndex-startIndex),result);
			if(height[startIndex] < height[endIndex]){
				startIndex++;
			} else if(height[startIndex] > height[endIndex]){
				endIndex--;
			}else {
				startIndex++;
				endIndex--;
			}
		}
		return result;
	}
}
