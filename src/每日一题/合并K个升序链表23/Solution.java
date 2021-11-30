package 每日一题.合并K个升序链表23;

import 每日一题.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 多路Bing归 用小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode result = new ListNode(0);
        ListNode head = result;
        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null) {
                queue.offer(lists[i]);
            }
        }

        while(!queue.isEmpty()){
            ListNode tmp = queue.poll();
            result.next = new ListNode(tmp.val);
            result = result.next;

            if(tmp.next!=null){
                queue.offer(tmp.next);
            }
        }
        return head.next;
    }
}
