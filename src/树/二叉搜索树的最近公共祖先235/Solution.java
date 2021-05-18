package 树.二叉搜索树的最近公共祖先235;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 235,236 通用解法，此时的方案是针对不是二叉搜索树的情况
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 */
public class Solution {

    List<TreeNode> resultListp = new ArrayList<>();
    List<TreeNode> resultListq = new ArrayList<>();
    boolean isfind = false;
    boolean isfindp = false;
    boolean isfindq = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
//        findPath(root,p,1);
//        isfind = false;
//        findPath(root,q,0);
        findAllPath(root,p,q);
        int point = 0;
        while(point<resultListp.size() && point<resultListq.size()){
            if(resultListq.get(point).val!=resultListp.get(point).val){
                break;
            }
            point++;
        }
        // System.out.println(resultList);
        return resultListq.get(point-1);
    }

    public void findAllPath(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return;
        }

        if(root.val==p.val){
            isfindp = true;
            resultListp.add(root);
        }
        if(root.val==q.val){
            isfindq = true;
            resultListq.add(root);
        }

        if(isfindp&&isfindq){
            return;
        }

        if(!isfindp){
            resultListp.add(root);
        }
        if(!isfindq){
            resultListq.add(root);
        }
        findAllPath(root.left,p,q);
        findAllPath(root.right,p,q);
        if(isfindp&&isfindq){
            return;
        }
        if(!isfindp){
            resultListp.remove(root);
        }
        if(!isfindq){
            resultListq.remove(root);
        }


    }
    public void findPath(TreeNode root, TreeNode target, int flag){
        if(root==null){
            return;
        }

        if(root.val==target.val){
            isfind = true;

            if (flag == 1) {
                resultListp.add(root);
            } else {
                resultListq.add(root);
            }
            return;
        }

        if(isfind){
            return ;
        }

        if(flag==1) {
            resultListp.add(root);
            findPath(root.left, target, 1);
            //root = resultList.get(resultList.size()-1);
            findPath(root.right, target, 1);

            if (isfind) {
                return;
            }
            resultListp.remove(root);
        }else{
            resultListq.add(root);
            findPath(root.left, target, 0);
            //root = resultList.get(resultList.size()-1);
            findPath(root.right, target, 0);

            if (isfind) {
                return;
            }
            resultListq.remove(root);
        }

    }


    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        s.lowestCommonAncestor(n1,n2,n3);
    }
}
