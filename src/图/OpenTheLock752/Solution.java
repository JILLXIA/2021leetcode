package 图.OpenTheLock752;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0',
 * or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        HashSet<Integer> deadSet = new HashSet<>();
        for(String dead: deadends){
            deadSet.add(Integer.parseInt(dead));
        }

        if(deadSet.contains(0)){
            return -1;
        }
        int targetValue = Integer.parseInt(target);

        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        deque.offerLast(0);
        visited.add(0);

        while(!deque.isEmpty()){
            int size = deque.size();
            count++;
            while(!deque.isEmpty() && size > 0){
                int tmpNode = deque.pollFirst();
                int[] units = new int[4];
                int divideNum = 1000;
                int beDividedNum = tmpNode;
                for(int i = 0;i < units.length;i++){
                    units[i] = beDividedNum / divideNum;
                    beDividedNum = beDividedNum % divideNum;
                    divideNum = divideNum / 10;
                }

                for(int i = 0;i < units.length;i++) {
                    int addNextUnit = units[i] + 1 == 10 ? 0 : units[i] + 1;
                    int subNextUnit = units[i] - 1 == -1 ? 9 : units[i] - 1;

                    int addNext = calInt(units,i,addNextUnit);
                    int subNext = calInt(units,i,subNextUnit);

                    if(!deadSet.contains(addNext) && !visited.contains(addNext)){
                        if(addNext == targetValue){
                            return count;
                        }
                        deque.offerLast(addNext);
                        visited.add(addNext);
                    }
                    if(!deadSet.contains(subNext) && !visited.contains(subNext)){
                        if(subNext == targetValue){
                            return count;
                        }
                        deque.offerLast(subNext);
                        visited.add(subNext);
                    }
                }
                size--;
            }
        }
        return -1;
    }

    public int calInt(int[] units, int index, int realValue){
        int result = 0;
        for(int i = 0;i < units.length; i++){
            if( i == index){
                result = result * 10 + realValue;
            } else {
                result = result * 10 + units[i];
            }
        }
        return result;
    }
}
