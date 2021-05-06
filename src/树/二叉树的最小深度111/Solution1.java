package 树.二叉树的最小深度111;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 尝试使用广度优先遍历的方法
 *
 * 树的广度遍历就是用队列的方法
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        int result = 0;
        if(root==null){
            return 0;
        }
        Deque<QueueNode> queue = new LinkedList<>();
        queue.offerLast(new QueueNode(root,1));
        while(!queue.isEmpty()){
            QueueNode cur= queue.pollFirst();//取出最上面的一个点
            if(cur.node.left==null&&cur.node.right==null){
                //如果这个点就是叶子节点了
                return cur.depth;
            }
            if(cur.node.left!=null){
                queue.offerLast(new QueueNode(cur.node.left,cur.depth+1));
            }
            if(cur.node.right!=null){
                queue.offerLast(new QueueNode(cur.node.right,cur.depth+1));
            }

        }
        return 0;
    }
}

class QueueNode{
    TreeNode node;
    int depth;

    public QueueNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
