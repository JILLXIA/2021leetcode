package labuladong.RemoveDuplicatesFromSortedList83;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
			if(slow.val==fast.val){
				fast = fast.next;
			} else {
				slow.next = fast;
				slow = slow.next;
			}
		}
		if(slow!=null)
			slow.next = null;
		return head;
	}
}
class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}