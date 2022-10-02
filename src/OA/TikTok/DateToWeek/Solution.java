package OA.TikTok.DateToWeek;

public class Solution {
    public int checkDayOfWeek(int year, int month, int day){
        /**
         * 1、W=[C/4]-2C+y+[y/4]+[26(m+1)/10]+d-1 （其中[ ]为取整符号）
         *
         * 2、其中,W是所求日期的星期数.如果求得的数大于7,可以减去7的倍数,直到余数小于7为止.
         * c是公元年份的前两位数字,y是已知公元年份的后两位数字;m是月数,d是日数.方括[ ]表示只截取该数的整数部分。
         *
         * 3、还有一个特别要注意的地方:所求的月份如果是1月或2月,
         * 则应视为前一年的13月或14月.所以公式中m 的取值范围不是1-12,而是3-14.
         */
        if(month==1||month==2){
            year--;
            month+=12;
        }
        int c = year/100;
        int y = year - c * 100;
        int week = (c/4) - 2* c + y + y/4 + (13 * (month+1)/5) + day - 1;
        while(week < 0){
            week += 7;
        }
        return week % 7;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkDayOfWeek(2000,5,16));
    }
}
