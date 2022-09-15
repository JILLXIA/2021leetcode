package Amazon.CloneGraph133;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */
public class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){ // edge case
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(node);
        map.put(node,new Node(node.val,new ArrayList<>()));
        while(!deque.isEmpty()){
            Node tmp = deque.pollFirst();
            Node newTmp = map.get(tmp);
            for(Node n:tmp.neighbors){
                if(!map.containsKey(n)) {
                    deque.offerLast(n);
                    map.put(n, new Node(n.val, new ArrayList<>()));
                }
                newTmp.neighbors.add(map.get(n));
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