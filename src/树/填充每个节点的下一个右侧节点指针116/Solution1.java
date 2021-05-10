package 树.填充每个节点的下一个右侧节点指针116;

/**
 * 想着尝试用递归的办法来解决
 *
 * 1. 第一种情况两个子节点属于同一个父节点，
 *    因此直接通过父节点建立两个子节点的 next 指针即可。
 *
 * 2. 第二种情况是连接不同父节点之间子节点的情况。更具体地说，
 *    连接的是第一个父节点的右孩子和第二父节点的左孩子。
 *    由于已经在父节点这一层建立了 next 指针，
 *    因此可以直接通过第一个父节点的 next 指针找到第二个父节点，
 *    然后在它们的孩子之间建立连接。
 */
public class Solution1 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }
        root.left.next = root.right;
        if(root.next!=null) {
            root.right.next = root.next.left;
        }else{
            root.right.next = null;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
