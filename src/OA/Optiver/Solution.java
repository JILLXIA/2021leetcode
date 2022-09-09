package OA.Optiver;

public class Solution {
    public int daysBetween(int y1, int m1, int d1, int y2, int m2, int d2) {
        // Go to y/1/1 for both dates. Then add either 365 or 366 for years in between.
        int days = 0;
        while (m1 != 1) {
            // days -= DaysBetween(y1, m1 - 1);
            m1--;
        }
        days -= d1;
        while (m2 != 1) {
            // days += DaysBetween(y2, m2 - 1);
            m2--;
        }
        days += d2;
        while (y1 != y2) {
            days += 365;
            // if (DaysBetween(y1, 2) == 29) days++;
        }
        return days;
    }
}
