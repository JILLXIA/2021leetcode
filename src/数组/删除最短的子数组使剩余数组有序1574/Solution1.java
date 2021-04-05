package 数组.删除最短的子数组使剩余数组有序1574;

public class Solution1 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left<arr.length-1 && arr[left]<=arr[left+1]){
            left++;//找到左侧的单调
        }

        while(right>0 && arr[right]>=arr[right-1]){
            right--;//可能right==left
        }

        if(left == arr.length-1){
            return 0;
        }
        int result = Math.min(arr.length-left-1,right);//如果全部删除前面或者全部删除后面

        //注意中间合并不是考虑全部向左或者全部向右合并
        //如果arr[left]<=arr[right]就继续左边扩
        //反之右边扩到满足<=的条件
        //左边扩的时候记录result的最小值就好了,因为右边扩的时候不一定满足条件!!!
        int j = right;
        int i = 0;
        while(i<=left&&j<=arr.length-1){
            if(arr[i]<=arr[j]){
                i++;
                result = Math.min(result,j-i);
            }else{
                j++;
            }
        }

        return result;
    }
}
