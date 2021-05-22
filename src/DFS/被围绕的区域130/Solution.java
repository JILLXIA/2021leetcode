package DFS.被围绕的区域130;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */

/**
 * 先找边缘的O,找到O之后转化为最大岛屿问题，找到和边缘的O相邻的O都变成#
 */
public class Solution {
    public void solve(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if((i==0 || j==0 || i==board.length-1
                        || j==board[0].length-1)&&board[i][j]=='O'){
                    dfs(i,j,board);
                }
            }
        }
        for(int i = 0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='#'||board[i][j]=='X'){
            return;
        }
        board[i][j] = '#';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);

    }
}

