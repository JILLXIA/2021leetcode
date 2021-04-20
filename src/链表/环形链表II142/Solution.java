package 链表.环形链表II142;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 */

/**
 * 设链表中环外部分的长度为 a。slow 指针进入环后，
 * 又走了 b 的距离与 fast 相遇。
 * 此时，fast 指针已经走完了环的 n 圈，
 * 因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc。
 *
 * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
 * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
 *
 * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，
 * 我们会发现：从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
 *
 * 因此，当发现 slow 与 fast 相遇时，
 * 我们再额外使用一个指针 ptr。
 * 起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
 * 见Solution1
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            if(slow==fast){
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(!hasCycle){
            return null;
        }
        //此时slow和fast在同一位置
        int count = 1;
        fast = fast.next;
        while(slow!=fast){
            count++;
            fast = fast.next;
        }

        fast = head;
        slow = head;//fast和slow两个节点归0
        int tmp = 0;
        while(tmp<count){
            fast = fast.next;
            tmp++;
        }
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}