package 链表.有序链表转换二叉搜索树109;

import java.util.List;

/**
 * 实际上找到中间的节点就可以了
 * 用快慢指针法找中间的节点
 * 不需要先遍历一遍求长度在/2
 *
 * 一次遍历就可以找到中间节点了
 */
public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    public static TreeNode buildTree(ListNode head, ListNode tail){
        if(head==null){
            return null;
        }
        if(head==tail){
            return null;
        }
        ListNode mid = findMid(head,tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(head,mid);
        root.right = buildTree(mid.next,tail);
        return root;
    }

    public static ListNode findMid(ListNode head, ListNode tail){
        ListNode node1 = head;
        ListNode node2 = head;
        if(head.next==tail){
            return head;
        }
        while(node2!=tail && node2.next!=tail){
            node2 = node2.next;
            node2 = node2.next;
            node1 = node1.next;
        }
        return node1;
    }
    public static void main(String[] args){
        Solution1 s = new Solution1();
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
