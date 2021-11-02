package 每日一题.删除链表中的节点237;

/**
 * 请编写一个函数，用于 删除单链表中某个特定节点 。
 * 在设计函数时需要注意，你无法访问链表的头节点head ，
 * 只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 */
public class Solution {
	public void deleteNode(ListNode node) {
		// 这道题细思极恐：如何让自己在世界上消失，但又不死？
		// —— 将自己完全变成另一个人，再杀了那个人就行了。
		ListNode nextNode = node.next;
		node.val = nextNode.val;
		node.next = nextNode.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}