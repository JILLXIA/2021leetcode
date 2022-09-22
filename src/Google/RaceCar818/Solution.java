package Google.RaceCar818;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):
 *
 * When you get an instruction 'A', your car does the following:
 * position += speed
 * speed *= 2
 * When you get an instruction 'R', your car does the following:
 * If your speed is positive then speed = -1
 * otherwise speed = 1
 * Your position stays the same.
 * For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.
 *
 * Given a target position target, return the length of the shortest sequence of instructions to get there.
 */
public class Solution {

    class CarPath{
        int position;
        int speed;
        public CarPath(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
    public int racecar(int target) {
        Deque<CarPath> deque = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        deque.offerLast(new CarPath(0,1));
        set.add("0;1");
        int step = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                CarPath tmp = deque.pollFirst();
                if(tmp.position==target){
                    return step;
                }
                // A
                int positionNextA = tmp.position + tmp.speed;
                int speedNextA = tmp.speed * 2;
                StringBuilder sbA = new StringBuilder();
                sbA.append(positionNextA);
                sbA.append(";");
                sbA.append(speedNextA);
                if(!set.contains(sbA.toString()) && positionNextA >= 0 && positionNextA <= 2 * target){
                    deque.offerLast(new CarPath(positionNextA,speedNextA));
                    set.add(sbA.toString());
                }
                // R
                int positionNextR = tmp.position;
                int speedNextR = 0;
                if(tmp.speed > 0){
                    speedNextR = -1;
                } else {
                    speedNextR = 1;
                }
                StringBuilder sbR = new StringBuilder();
                sbR.append(positionNextR);
                sbR.append(";");
                sbR.append(speedNextR);
                // 注意给position 限定范围，不能小于0；同时也不能大于两倍的target
                if(!set.contains(sbR.toString())&& positionNextA >= 0 && positionNextA <= 2 * target){
                    deque.offerLast(new CarPath(positionNextR,speedNextR));
                    set.add(sbR.toString());
                }
                size--;
            }
            step++;
        }
        return -1;
    }
}
