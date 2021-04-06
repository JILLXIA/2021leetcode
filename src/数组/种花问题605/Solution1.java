package 数组.种花问题605;

/**
 * 两端不需要另外判断，可以加上一个虚无0
 * 计算连续0的数量
 *
 * 1~2个0：可种0朵；
 *
 * 3~4个：可种1朵；
 *
 * 5~6个：可种2朵；
 *
 * ...
 *
 * count个：可种 (count-1)/2 朵
 */
public class Solution1 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countZero = 1;
        int count = 0;
        for(int i = 0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                countZero++;
            }else{
                count+=(countZero-1)/2;
                countZero = 0;
            }
            if(count>=n){
                return true;
            }
        }
        countZero++;
        count+=(countZero-1)/2;
        if(count>=n){
            return true;
        }else{
            return false;
        }
    }
}
