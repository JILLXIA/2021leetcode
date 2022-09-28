package Google.SwapAdjacentInLRString777;

/**
 * In a string composed of 'L', 'R', and 'X' characters,
 * like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX",
 * or replacing one occurrence of "RX" with "XR".
 * Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of
 * moves to transform one string to the other.
 */
public class Solution {
    public boolean canTransform(String start, String end) {
        if(start.length()!=end.length() || !start.replace("X","").equals(end.replace("X",""))){
            return false;
        }
        int point1 = 0;
        int point2 = 0;
        while(point1 < start.length() && point2 < end.length()){
            while(point1 < start.length() && start.charAt(point1)=='X'){
                point1++;
            }
            while(point2 < end.length() && end.charAt(point2)=='X'){
                point2++;
            }

            if(point1 >= start.length() && point2 < end.length()){
                return false;
            }

            if(point2 >= end.length() && point1 < start.length()){
                return false;
            }

            if(point2 >= end.length() && point1 >= start.length()){
                return true;
            }
            if(start.charAt(point1)=='L' && point1 < point2){
                return false;
            }
            if(start.charAt(point1)=='R' && point1 > point2){
                return false;
            }
            point1++;
            point2++;
        }
        return true;
    }
}
