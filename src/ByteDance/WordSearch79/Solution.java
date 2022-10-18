package ByteDance.WordSearch79;

/**
 * Given an m x n grid of characters board and a string word,
 * return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(dfs(board, i,j,word,0,isVisited)){
                    return true;
                }

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] isVisited){
        if(index==word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j>=board[0].length || isVisited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        isVisited[i][j] = true;

        for(int k = 0;k<dirs.length;k++){
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            if(dfs(board, nextI, nextJ, word, index + 1, isVisited)){
                return true;
            }
        }
        isVisited[i][j] = false;
        return false;
    }
}
