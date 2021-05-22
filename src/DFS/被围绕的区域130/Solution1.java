package DFS.被围绕的区域130;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 尝试用BFS非递归的写法
 */
public class Solution1 {
    public void solve(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if((i==0 || j==0 || i==board.length-1
                        || j==board[0].length-1)&&board[i][j]=='O'){
                    bfs(i,j,board);
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
    public void bfs(int i,int j,char[][] board){
        Deque<Position> deque = new LinkedList<>();
        deque.offerLast(new Position(i,j));
        board[i][j] = '#';
        while(!deque.isEmpty()){
            Position cur = deque.pollFirst();
            if(cur.x-1>=0 && board[cur.x-1][cur.y]=='O'){
                deque.offerLast(new Position(cur.x-1,cur.y));
                board[cur.x-1][cur.y] = '#';
            }

            if(cur.x+1<board.length && board[cur.x+1][cur.y]=='O'){
                deque.offerLast(new Position(cur.x+1,cur.y));
                board[cur.x+1][cur.y] = '#';
            }

            if(cur.y+1<board[0].length && board[cur.x][cur.y+1]=='O'){
                deque.offerLast(new Position(cur.x,cur.y+1));
                board[cur.x][cur.y+1] = '#';
            }

            if(cur.y-1>=0 && board[cur.x][cur.y-1]=='O'){
                deque.offerLast(new Position(cur.x,cur.y-1));
                board[cur.x][cur.y-1] = '#';
            }
        }
    }
}

class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
