package DFS.克隆图133;

import java.util.*;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
public class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap();
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(node);
        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();
            if(!map.containsKey(cur)){
                map.put(cur,new Node(cur.val));
            }

            //便利且建立邻居节点
            for(int i = 0;i<cur.neighbors.size();i++){
                if(!map.containsKey(cur.neighbors.get(i))) {
                    deque.offerLast(cur.neighbors.get(i));
                    map.put(cur.neighbors.get(i),new Node(cur.neighbors.get(i).val));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }

        }
        return map.get(node);
    }

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}