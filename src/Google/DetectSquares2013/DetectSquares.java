package Google.DetectSquares2013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetectSquares {
    // 固定对角线两个点
    // 原本只想遍历同x或者同y的点，其实可以直接遍历所有的点，找到对角线
    // 原本想这用hashMap进行点的计数，其实可以直接用int[][]来计数，注意观察constraint
    int[][] count;
    List<int[]> list;
    public DetectSquares() {
        count = new int[1001][1001];
        list = new ArrayList<>(); // store all the node
    }

    public void add(int[] point) {
        count[point[0]][point[1]]++;
        list.add(point);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;

        for(int i = 0;i<list.size();i++){
            int x_d = list.get(i)[0];
            int y_d = list.get(i)[1];
            if(x_d - x == 0 || Math.abs(x_d - x)!=Math.abs(y_d - y)){
                continue;
            }
            result += count[x_d][y] * count[x][y_d];
        }
        return result;
    }
}
