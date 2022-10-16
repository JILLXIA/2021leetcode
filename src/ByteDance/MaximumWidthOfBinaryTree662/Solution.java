package ByteDance.MaximumWidthOfBinaryTree662;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        // Deque
        // 1
        // 3 2 left = 0; right = 1
        // 5 3 null 9 left = 0, right = 3 right - left +1 = length;
        //

        // 1
        // 3 2 left = 0; right =1 right - left +1 = 2
        // 5 null null 9
        // 6 null null null null null 7 null left = 0 right = 6 right - left + 1 = 7

        Deque<Pair> deque = new LinkedList();
        deque.offerLast(new Pair(root,1));
        int result = 1;
        while(!deque.isEmpty()){
            int left = deque.peekFirst().index;
            int right = -1;
            int cur = deque.size();
            while(cur > 0){
                Pair tmp = deque.pollFirst();
                right = tmp.index;
                if(tmp.node.left!=null){
                    deque.offerLast(new Pair(tmp.node.left,tmp.index*2));
                }
                if(tmp.node.right!=null){
                    deque.offerLast(new Pair(tmp.node.right,tmp.index*2+1));
                }
                cur--;
            }

            result = Math.max(result,right - left +1);

            // if(left==-1){
            //     break;
            // }
        }
        return result;
    }
}
