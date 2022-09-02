package OA.IMC.busyIntersection;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] busyIntersection(int[] arrival, int[] street){
        // 0: Main Street; 1: 1st Avenue
        int n = arrival.length;
        Deque<int[]> main_car = new LinkedList<>();
        Deque<int[]> first_car = new LinkedList<>();
        Deque<int[]> time_arrive_car = new LinkedList<>();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            time_arrive_car.add(new int[]{arrival[i],i});
        }
        int currentTime = 0;
        int preCar = -1;// -1: previous sec no car pass
        int[] currentTimeCar;
        while(!time_arrive_car.isEmpty() || !main_car.isEmpty() || !first_car.isEmpty())
        {
            if(main_car.isEmpty() && first_car.isEmpty())
            {
                if(time_arrive_car.peek()[0] != currentTime){
                    preCar=-1;
                }
                currentTime=time_arrive_car.peek()[0];
            }
            while(!time_arrive_car.isEmpty() && time_arrive_car.peek()[0]==currentTime) {
                currentTimeCar = time_arrive_car.poll();
                if (street[currentTimeCar[1]] == 0) {
                    main_car.add(currentTimeCar);
                } else if (street[currentTimeCar[1]] == 1) {
                    first_car.add(currentTimeCar);
                }
            }
            if((preCar==-1 || preCar==1 || main_car.isEmpty()) && !first_car.isEmpty())
            {
                int[] cur_first_avenue=first_car.poll();
                result[cur_first_avenue[1]]=currentTime;
                currentTime++;
                preCar=1;
            }
            else if(!main_car.isEmpty())
            {
                int[] cur_main_street=main_car.poll();
                result[cur_main_street[1]]=currentTime;
                currentTime++;
                preCar=0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] show = s.busyIntersection(new int[]{0,0,1,4},new int[]{0,1,1,0});
        for(int i = 0;i<show.length;i++){
            System.out.println(show[i]);
        }
    }
}
