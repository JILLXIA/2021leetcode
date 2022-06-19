package labuladong.CourseSchedule207;
// BFS 也可以解决

/**
 * 1. 构建邻接表
 * 2. 构建一个indegree数组记录每个节点的入度， indegree[i] 记录节点i的入度
 * 3. 对BFS队列进行初始化，将入度为0的节点首次装入队列
 * 4. 开始执行BFS循环，不断弹出队列中的节点，减少相邻节点的入度，并且将入度为0的节点加入队列
 * 5. 最终如果所有节点都被遍历过说明不成环
 */
public class Solution1 {
}
