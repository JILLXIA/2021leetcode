package ByteDance.StepByStepDirectionsFromABinaryTreeNodeToAnother2096;

import 树.TreeNode;

public class Solution1 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder();
        dfs(root, startValue, sb1);

        StringBuilder sb2 = new StringBuilder();
        dfs(root, destValue, sb2);

        // 找到前缀
        int index1 = sb1.length()-1;
        int index2 = sb2.length()-1;
        int count = 0;
        while(index1 >= 0 && index2 >= 0 && sb1.charAt(index1)==sb2.charAt(index2)){
            index1--;
            index2--;
            count++;
        }
        StringBuilder result = new StringBuilder();
        for(int i = count;i<sb1.length();i++){
            result.append("U");
        }
        result.append(sb2.reverse().substring(count));
        return result.toString();
    }
    // dfs遍历寻找节点的时候可以想到，先找到再加入sb的策略；
    // 这样的话生成的sb就是倒着的正确序列
    public boolean dfs(TreeNode root, int val, StringBuilder sb){
        if(root==null){
            return false;
        }
        if(root.val==val){
            return true;
        }
        if(dfs(root.left,val,sb)){
            // 看看是不是再左边，如果是就加上路径
            sb.append("L");
        } else if(dfs(root.right,val,sb)){
            sb.append("R");
        }
        return sb.length() > 0;
    }
}
