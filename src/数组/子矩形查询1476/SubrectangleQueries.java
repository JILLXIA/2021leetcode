package 数组.子矩形查询1476;

import java.util.ArrayList;

/**
 * 或者用空间换取时间的方法
 * history数组存放历史的数据
 */
public class SubrectangleQueries {
    int[][] rectangle;
    ArrayList<int[]> history = new ArrayList<>();
    public SubrectangleQueries(int[][] rectangle) {
        //this.rectangle = rectangle;(浅拷贝)

        //深拷贝 二维数组的深拷贝要for循环+clone
        this.rectangle = new int[rectangle.length][rectangle[0].length];
        for(int i=0;i<rectangle.length;i++){
            this.rectangle[i] = rectangle[i].clone();
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int[] temp = {row1,col1,row2,col2,newValue};
        history.add(temp);
    }

    public int getValue(int row, int col) {
        for(int i = history.size()-1;i>=0;i--){
            if((row<=history.get(i)[2]&&row>=history.get(i)[0]) &&
                    (col<=history.get(i)[3] && col>=history.get(i)[1])){
                return history.get(i)[4];
            }
        }
        return rectangle[row][col];
    }
}
