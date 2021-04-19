package 链表.复制带随机指针的链表138;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
 * 该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，
 * 其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，
 * 其中 X.random --> Y 。
 * 那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。
 * 每个节点用一个[val, random_index]表示：
 *
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；
 * 如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */

/**
 * 因为有两个指针，可以把链表想象成一个图，进行深度遍历
 */
public class Solution {
    HashMap<Node,Node> map = new HashMap<>();
    //key是原来的节点，value是现在的节点
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node result;
        if(!map.containsKey(head)) {
            //如果没有被复制，就创建一个新节点
            result = new Node(head.val);
            map.put(head, result);
        }else{
            //如果已经复制过了，返回value
            result = map.get(head);
            return result;//直接返回，不要在递归找next和random了
        }
        result.next = copyRandomList(head.next);//先遍历完next再开始遍历random 相当于DFS
        result.random = copyRandomList(head.random);

        return result;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}