package OA.Amazon.minNetStock;

public class Solution {
    // find earliest month
    // preSum 需要定义为long
    public int minNetStock(int[] arr){
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            preSum[i] = preSum[i-1] + arr[i];
        }
        int minChange = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0;i<arr.length-1;i++){
            int netPriceChange = Math.abs(preSum[i]/(i+1) - (preSum[arr.length-1] - preSum[i])/(arr.length-i-1));
            if(netPriceChange < minChange){
                minChange = netPriceChange;
                result = i;
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minNetStock(new int[]{1,1,1,1,1,1}));
    }
}
