package Google.Single_ThreadedCPU1834;

import java.util.*;

/**
 * You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.
 *
 * You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
 *
 * If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 * If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 * Once a task is started, the CPU will process the entire task without stopping.
 * The CPU can finish a task then start a new one instantly.
 * Return the order in which the CPU will process the tasks.
 */
public class Solution {
    class Task{
        int index;
        int enqueueTime;
        int processingTime;
        public Task(int index, int enqueueTime, int processingTime){
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.processingTime==o2.processingTime){
                    return o1.index - o2.index;
                }
                return o1.processingTime - o2.processingTime;
            }
        });

        List<Task> taskList = new ArrayList<>();
        for(int i = 0;i< tasks.length;i++){
            taskList.add(new Task(i,tasks[i][0],tasks[i][1]));
        }
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.enqueueTime - o2.enqueueTime;
            }
        });
        int[] result = new int[tasks.length];
        int index = 0;
        int time = 0;
        int arrIndex = 0;
        // 还会有idel time
        while(!pq.isEmpty() || arrIndex < taskList.size()){
            if(pq.isEmpty()){
                time = Math.max(time, taskList.get(arrIndex).enqueueTime);
            }

            while(arrIndex < taskList.size() && time >= taskList.get(arrIndex).enqueueTime){
                pq.offer(taskList.get(arrIndex));
                arrIndex++;
            }

            Task tmp = pq.poll();
            time += tmp.processingTime;
            result[index] = tmp.index;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
    }
}
