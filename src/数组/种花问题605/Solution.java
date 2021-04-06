package 数组.种花问题605;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，
 * 其中 0 表示没种植花，1 表示种植了花。另有一个数n ，
 * 能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if(flowerbed.length==1){
            if((flowerbed[0]==0&&n==1) || (flowerbed[0]==1&&n==0)
            || (flowerbed[0]==0&&n==0)){
                return true;
            }else{
                return false;
            }
        }

        for(int i = 0;i<flowerbed.length;i++){
            if(i==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                count++;
                flowerbed[i] = 1;
                continue;
            }

            if(i==flowerbed.length-1 && flowerbed[i]==0 &&
                    flowerbed[i-1]==0){
                count++;
                flowerbed[i] = 1;
                continue;
            }

            if((i!=0&&i!= flowerbed.length-1)&&
                    flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0){
                count++;
                flowerbed[i] = 1;
                continue;
            }
        }
        if(count>=n){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] arr = {1,0,1,0,1,0,1};
        System.out.println(s.canPlaceFlowers(arr,1));
    }
}
