package 数组.矩阵中的幻方840;

import java.util.Arrays;

/**
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 */
public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int length1 = grid.length;
        int length2 = grid[0].length;

        if(length1 < 3 || length2 < 3){
            return 0;
        }
        int[][] testArr = new int[3][3];
        int count = 0;
        for(int i = 0;i<length1-2;i++){
            for(int j = 0;j<length2-2;j++){
                System.arraycopy(grid[i],j,testArr[0],0,3);
                System.arraycopy(grid[i+1],j,testArr[1],0,3);
                System.arraycopy(grid[i+2],j,testArr[2],0,3);
                if(check1(testArr)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 相信很容易找出这八个解的共同点，
     * 首先中间的元素都是五，
     * 角上元素都是偶数，
     * 中点都是奇数。
     * 同一行的解可以通过旋转得到，
     * 第一行镜像，可以得到第二行。
     * 也就是说，三阶幻方本质只有一种解，其余都是旋转镜像的体现。
     *
     */
    public static boolean check1(int[][] temp){
        int[] arr = {8,1,6,7,2,9,4,3};
        int[] tempArr = {temp[0][0],temp[0][1],temp[0][2],
        temp[1][2],temp[2][2],temp[2][1],temp[2][0],temp[1][0]};
        for(int i = 0;i<8;i+=2){
            if(tempArr[0]==arr[i]){
                int[] temp1=new int[8];
                System.arraycopy(arr,i,temp1,0,8-i);
                System.arraycopy(arr,0,temp1,8-i,i);

                int[] temp2 = new int[8];
                for(int j = i;j>=0;j--){
                    temp2[i-j] = arr[j];
                }
                for(int k = i+1;k<=7;k++){
                    temp2[k] = arr[7-k+i+1];
                }

                return Arrays.equals(tempArr,temp1) || Arrays.equals(tempArr,temp2);
            }
        }
        return false;
    }
    public static boolean check(int[][] temp){
        //暴力判断幻方会有情况被遗漏
        if(temp[1][1]==5 && (temp[0][0]!=temp[2][2])
        && (temp[0][0]+temp[2][2]==10) && (temp[0][2]!=temp[2][0])
        && (temp[0][2]+temp[2][0]==10) && (temp[0][0]+temp[0][1]+temp[0][2]==15)
        && (temp[1][0]+temp[1][1]+temp[1][2]==15) && (temp[2][0]+temp[2][1]+temp[2][2]==15)
        && (temp[0][0]+temp[1][0]+temp[2][0]==15) && (temp[0][1]+temp[1][1]+temp[2][1]==15)
                && (temp[0][2]+temp[1][2]+temp[2][2]==15)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] arr = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int[][] arr1 = {{4,9,2},{3,5,7},{8,1,6}};
        System.out.println(s.numMagicSquaresInside(arr1));
    }
}
