package 链表.有序链表转换二叉搜索树109;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，
 * 一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        //求出链表的长度
        ListNode tmp = head;
        while(tmp!=null){
            length++;
            tmp = tmp.next;
        }
        TreeNode root = buildTree(head,length);
        //确定根结点
        return root;

    }
    public static TreeNode buildTree(ListNode head,int length){
        if(length==1){
            return new TreeNode(head.val);
        }
        if(length==0){
            return null;
        }
        int pos = 1;
        ListNode posNode = head;
        while(pos<length/2+1){
            pos++;
            posNode = posNode.next;
        }
        TreeNode root = new TreeNode(posNode.val);
        ListNode righthead = posNode.next;
        root.left = buildTree(head,length/2);
        root.right = buildTree(righthead,length-length/2-1);
        return root;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(s.sortedListToBST(n1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}