package Google.FindAllPossibleRecipesFromGivenSupplies2115;

import java.util.*;

public class Solution1 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // 用hashMap来存储图
        HashMap<String, HashSet<String>> next = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();

        for(int i = 0;i<recipes.length;i++){
            for(int j = 0;j<ingredients.get(i).size();j++){
                if(!next.containsKey(ingredients.get(i).get(j))){
                    next.put(ingredients.get(i).get(j),new HashSet<>());
                }
                next.get(ingredients.get(i).get(j)).add(recipes[i]);

                indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
            }
        }

        // indegree可以不用加supply
        Deque<String> deque = new LinkedList<>();
        for(int i = 0;i<supplies.length;i++){
            deque.offerLast(supplies[i]);
        }
        List<String> result = new ArrayList<>();
        while(!deque.isEmpty()){
            String tmp = deque.pollFirst();
            if(!next.containsKey(tmp)){
                continue;
            }
            HashSet<String> nextNode = next.get(tmp);
            for(String node: nextNode){
                indegree.put(node,indegree.get(node)-1);
                if(indegree.get(node)==0){
                    deque.offerLast(node);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String[] recipes = new String[]{"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("yeast");
        tmp.add("flour");
        ingredients.add(tmp);
        String[] supplies = new String[]{"yeast","flour","corn"};
        System.out.println(s.findAllRecipes(recipes,ingredients,supplies));

    }
}
