package Amazon.TrappingRainWater42;

public class Solution1 {
    public int trap(int[] height) {
        int leftHighest = height[0];
        int rightHighest = height[height.length-1];
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left <= right){
            // left==right的时候一定装不了水
            leftHighest = Math.max(leftHighest, height[left]);
            rightHighest = Math.max(rightHighest,height[right]);
            if(leftHighest <= rightHighest){
                result += leftHighest - height[left];
                left++;
            } else {
                result += rightHighest - height[right];
                right--;
            }
        }

        return result;
    }
}
