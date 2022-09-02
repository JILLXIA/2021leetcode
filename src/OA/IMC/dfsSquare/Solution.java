package OA.IMC.dfsSquare;

public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty, int c) {
        return dfs(sx,sy,tx,ty,c);
    }

    public boolean dfs(int currentX, int currentY, int tx, int ty, int c){
        if(!isSquare(currentX+currentY)){
            return false;
        }
        if(currentY==ty && currentX==tx){
            return true;
        }

        if(currentY > ty || currentX > tx){
            return false;
        }
        return dfs(currentX+currentY, currentY,tx,ty,c)
                || dfs(currentX, currentY + currentX,tx,ty,c)
                || dfs(currentX+c,currentY+c,tx,ty,c);
    }

    public static boolean isSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);
        } catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isSquare(101));
    }
}
