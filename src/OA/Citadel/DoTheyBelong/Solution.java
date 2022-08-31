package OA.Citadel.DoTheyBelong;

public class Solution {
    boolean isInTriangle(Point p1, Point p2, Point p3, Point o){
        if(product(p1, p2, p3)<0) return isInTriangle(p1,p3,p2,o);
        if(product(p1, p2, o)>0 && product(p2, p3, o)>0 && product(p3, p1, o)>0)
            return true;
        return false;
    }

    double product(Point p1, Point p2, Point p3){
        return (p2.x-p1.x)*(p3.y-p1.y) - (p2.y-p1.y)*(p3.x-p1.x);
    }
}

class Point{
    double x;
    double y;
}