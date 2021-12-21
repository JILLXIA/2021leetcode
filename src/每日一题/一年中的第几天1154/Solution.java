package 每日一题.一年中的第几天1154;

/**
 * 给你一个字符串date ，按 YYYY-MM-DD 格式表示一个
 * 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，
 * 依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 */
public class Solution {
    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int feb = isRunYear(Integer.parseInt(arr[0])) ? 29 :28;
        int[] months = new int[]{31,feb,31,30,31,30,31,31,30,31,30,31};
        int month = Integer.parseInt(arr[1]);
        int result = 0;
        for(int i = 0;i<month-1;i++){
            result += months[i];
        }
        return result+Integer.parseInt(arr[2]);
    }

    public boolean isRunYear(int year) {
        return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
    }
}
