package 每日一题.最大平均通过率1792;

/**
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。
 * 给你一个二维数组 classes，其中
 * classes[i] = [passi, totali]，
 * 表示你提前知道了第i个班级总共有totali个学生，其中只有passi个学生可以通过考试。
 *
 * 给你一个整数extraStudents，表示额外有extraStudents个聪明的学生，
 * 他们 一定能通过任何班级的期末考。你需要给这extraStudents个学生每人都安排一个班级，
 * 使得 所有班级的 平均通过率 最大。
 *
 * 一个班级的通过率等于这个班级通过考试的学生人数除以这个班级的总人数。
 * 平均通过率是所有班级的通过率之和除以班级数目。
 *
 * 请你返回在安排这 extraStudents 个学生去对应班级后的
 * 最大平均通过率。与标准答案误差范围在10-5以内的结果都会视为正确结果。
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 完全想不到能够模拟的数据结构
 *
 * 贪心，每次加到(p+1)/(t+1)-p/t最大的一个地方
 *
 * 注意整数的除法一定要先转成double
 */
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Component> queue = new PriorityQueue<>(new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                // 如果认为o1优先级比o2高，先出o1 compare返回<0的整数
                // 如果认为o2优先级比o1高，先出o2 compare返回>0的整数
                return o2.count-o1.count>=0?1:-1;
            }
        });

        //初始化优先队列
        for(int i = 0;i<classes.length;i++){
            //System.out.println("1  "+(double)(classes[i][0]+1)/(classes[i][1]+1));
            //System.out.println("2  "+(double)(classes[i][0])/(classes[i][1]));

            queue.offer(new Component(((double)(classes[i][0]+1)/(double)(classes[i][1]+1)-(double)classes[i][0]/classes[i][1]),classes[i][0],classes[i][1]));
        }

        for(int i = 0;i<extraStudents;i++){
            Component temp = queue.poll();
            temp.pass++;
            temp.total++;
            temp.count = (double)(temp.pass+1)/(temp.total+1)-(double)temp.pass/temp.total;
            queue.offer(new Component(temp.count,temp.pass,temp.total));
        }
        double result = 0.0;
        while(!queue.isEmpty()){
            Component tmp = queue.poll();
            result += (double)tmp.pass/tmp.total;
        }
        return (double)result/classes.length;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}},2);
    }
}
class Component{
    double count;
    int pass;
    int total;

    public Component(double count, int pass, int total) {
        this.count = count;
        this.pass = pass;
        this.total = total;
    }
}