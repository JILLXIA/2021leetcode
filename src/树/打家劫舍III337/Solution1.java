package 树.打家劫舍III337;

import 树.TreeNode;

import java.util.HashMap;

public class Solution1 {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }

        int money = root.val;
        if(root.left!=null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            money += rob(root.right.left) + rob(root.right.right);
        }
        int result = Math.max(money,rob(root.left)+rob(root.right));
        map.put(root,result);
        return result;
    }
}
