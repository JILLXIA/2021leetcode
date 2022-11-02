package Top100Question.MergeKSortedLists23;

import 每日一题.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue sorted by value
        // poll() -> list = list.next; if(list==null) -> do not push
        if(lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        if(pq.isEmpty()){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(pq.size() > 1){
            ListNode tmp = pq.poll();
            curr.next = tmp;
            curr = curr.next;
            tmp = tmp.next;
            if(tmp!=null){
                pq.add(tmp);
            }
        }
        curr.next = pq.poll();
        return dummy.next;
    }
}
