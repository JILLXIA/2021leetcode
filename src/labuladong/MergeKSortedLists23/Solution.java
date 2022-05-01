package labuladong.MergeKSortedLists23;

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
		// use PriorityQueue to find out the minimum node in lists
		// 优先队列add一次的复杂度是logK，所以总的时间复杂度是NlogK,N是链表的节点总数
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val- o2.val;
			}
		});
		ListNode resultHead = new ListNode();
		ListNode current = resultHead;
		for(int i = 0;i< lists.length;i++){
			if(lists[i]!=null)
				// notice:0 <= lists[i].length <= 500
				queue.add(lists[i]);
		}
		while(!queue.isEmpty()){
			ListNode tmp = queue.poll();
			current.next = tmp;
			current = current.next;
			if(tmp.next!=null)
				queue.add(tmp.next);
		}
		return resultHead.next;
	}
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}