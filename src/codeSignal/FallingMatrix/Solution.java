package codeSignal.FallingMatrix;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] field = new int[][]{{0,0,0},{0,0,0},{0,0,0},{1,0,0},{1,1,0}};
//        int[][] figure = new int[][]{{0,0,1},{0,1,1},{0,0,1}};
        int[][] field = new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,1,0,1,0},{1,0,1,0,1}};
        int[][] figure = new int[][]{{1,1,1},{1,0,1},{1,0,1}};
        System.out.println(s.fallingMatrix(field,figure));
    }
    public int fallingMatrix(int[][] field, int[][] figure){
        if(field.length<3 || field[0].length < 3){
            return -1;
        }
        for(int i = field.length - 2;i>=1;i--){
            for(int j = field[0].length-2;j>=1;j--){
                if(!isFit(field, figure,i,j)){
                    continue;
                }
                int indexF = 0;
                int count = 0;
                for(int z = i-1;z<=i+1;z++) {
                    for (int k = 0; k < field[0].length; k++) {
                        if (k >= j - 1 && k <= j + 1) {
                            count += figure[z-(i-1)][indexF]==1 ? 1: field[z][k];
                            indexF++;
                        } else {
                            count += field[z][k];
                        }
                    }
                    if(count== field[0].length){
                        return j-1;
                    } else{
                        indexF = 0;
                        count = 0;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isFit(int[][] field, int[][] figure, int x,int y){
        // x,y是figure在field内的中心
        int[][] dir = new int[][]{{1,0},{1,1},{1,-1},{0,0},{0,1},{0,-1},{-1,0},{-1,1},{-1,-1}};
        for(int i = 0;i< dir.length;i++){
            int textX = x + dir[i][0];
            int textY = y + dir[i][1];
            int figX = 1+dir[i][0];
            int figY = 1+dir[i][1];
            if(field[textX][textY]==1 && figure[figX][figY]==1){
                return false;
            }
        }
        return true;
    }
}
