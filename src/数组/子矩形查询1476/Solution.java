package 数组.子矩形查询1476;

/**
 * 请你实现一个类SubrectangleQueries，它的构造函数的参数是一个 rows x cols的矩形（这里用整数矩阵表示），并支持以下两种操作：
 *
 * 1.updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * 用newValue更新以(row1,col1)为左上角且以(row2,col2)为右下角的子矩形。
 * 2.getValue(int row, int col)
 *
 * 返回矩形中坐标 (row,col) 的当前值。
 */


public class Solution {
    int[][] rectangle;
    public Solution(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1;i<=row2;i++){
            for(int j = col1;j<=col2;j++){
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */