package Top100Question.ValidSudoku36;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 三个二维数组
        int[][] rows = new int[10][10];// line -> dict
        int[][] cols = new int[10][10];// col -> dict
        int[][] cubics = new int[10][10]; // cubics -> dict

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                char c = board[i][j];
                if(rows[i][c-'0']!=0 || cols[j][c-'0']!=0 || cubics[(i/3)*3+j/3][c-'0']!=0){
                    return false;
                }
                rows[i][c-'0']++;
                cols[j][c-'0']++;
                cubics[(i/3)*3+j/3][c-'0']++;
            }
        }
        return true;
    }
}
