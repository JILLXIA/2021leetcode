package DFS.克隆图133;

import java.util.HashMap;

/**
 * 尝试用深度优先便利来解题
 */
public class Solution1 {
    HashMap<Node,Node> map = new HashMap();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        //先新建当前节点
        map.put(node,new Node(node.val));

        //宽度子集用for循环，每一层利用dfs
        for(Node n:node.neighbors){
            map.get(node).neighbors.add(cloneGraph(n));
        }
        return map.get(node);
    }
}
