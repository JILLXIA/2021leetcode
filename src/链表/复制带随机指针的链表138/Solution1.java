package 链表.复制带随机指针的链表138;

import java.util.HashMap;

//也可以用BFS
public class Solution1 {
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node result = new Node(head.val);
        Node newHead = result;
        map.put(head,result);
        while(head!=null){
            if(head.next!=null&&!map.containsKey(head.next)){//next节点没有被复制
                result.next = new Node(head.next.val);
                map.put(head.next,result.next);
            }else{
                result.next = map.get(head.next);
            }

            if(head.random!=null&&!map.containsKey(head.random)){
                result.random = new Node(head.random.val);
                map.put(head.random,result.random);
            }else{
                result.random = map.get(head.random);
            }
            head = head.next;
            result = result.next;
        }
        return newHead;
    }
}
