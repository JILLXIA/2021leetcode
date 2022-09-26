package Google.FindAllPossibleRecipesFromGivenSupplies2115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.
 *
 * You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
 *
 * Return a list of all the recipes that you can create. You may return the answer in any order.
 *
 * Note that two recipes may contain each other in their ingredients.
 */
// no work, 不知道为啥不行，必须用拓扑排序
public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> recipesToingredients = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i< recipes.length;i++){
            recipesToingredients.put(recipes[i],ingredients.get(i));
        }

        for(int i = 0;i< supplies.length;i++){
            set.add(supplies[i]);
        }
        HashSet<String> isVisited = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(int i = 0;i<recipes.length;i++){
            if(check(recipesToingredients,set,recipes[i], isVisited)){
                result.add(recipes[i]);
            }
            isVisited.clear();
        }
        return result;
    }

    public boolean check(HashMap<String,List<String>> recipesToingredients, HashSet<String> set, String recipe, HashSet<String> isVisited){
        if(isVisited.contains(recipe)){
            return false;
        }
        if(!recipesToingredients.containsKey(recipe)){
            return false;
        }
        List<String> ingredient = recipesToingredients.get(recipe);
        for(String item: ingredient){
            if(set.contains(item)){
                continue;
            }
            if(!recipesToingredients.containsKey(item)){
                return false;
            }
            isVisited.add(item);
            boolean isContain = check(recipesToingredients,set,item,isVisited);
            if(!isContain){
                return false;
            }
        }
        set.add(recipe);
        return true;
    }
}
