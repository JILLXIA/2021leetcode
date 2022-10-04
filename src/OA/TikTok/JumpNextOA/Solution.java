package OA.TikTok.JumpNextOA;

/**
 * Suppose you have an array of elements as 13, 10, 21, 20.
 *
 * Now you need to find out minimum moves to segregate even followed by odd elements in the Array so that all even elements will be in the front of the array and all odd elements will be in the back of the array. So the resulting array will 20, 10, 21, 13.
 *
 * It’s simply you need to swap element 13 with element 20 in the array. So you need only one move to segregate the even and odd elements in the array.
 */
public class Solution {
    static int minMovesToEvenFollowedByOdd(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int result = 0;
        while(left < right){
            while(left < right && arr[left] % 2==0){
                left++;
            }
            while(left < right && arr[right] % 2!=0){
                right--;
            }

            if(left < right){
                left++;
                right--;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Solution.minMovesToEvenFollowedByOdd(new int[]{2,4,6,8}));
    }
}
