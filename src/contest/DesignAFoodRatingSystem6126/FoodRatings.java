package contest.DesignAFoodRatingSystem6126;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
class Food{
	String name;
	String cuisine;
	int rate;

	public Food(String name, String cuisine, int rate) {
		this.name = name;
		this.cuisine = cuisine;
		this.rate = rate;
	}
}
public class FoodRatings {
	HashMap<String, Food> foodToCuisine; //get Food (object) by food name
	HashMap<String, PriorityQueue<Food>> cuisineToFood;
	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
		foodToCuisine = new HashMap<>();
		cuisineToFood = new HashMap<>();
		int n = foods.length;

		for(int i = 0;i<n;i++){
			Food tmpFood = new Food(foods[i],cuisines[i],ratings[i]);
			foodToCuisine.put(foods[i],tmpFood);
			if(cuisineToFood.containsKey(cuisines[i])){
				cuisineToFood.get(cuisines[i]).add(tmpFood);
			} else {
				PriorityQueue<Food> tmp = new PriorityQueue<>(new Comparator<Food>() {
					@Override
					public int compare(Food o1, Food o2) {
						if(o1.rate==o2.rate){
							return o1.name.compareTo(o2.name); //  lexicographically smaller name
						}
						return o2.rate-o1.rate;
					}
				});
				tmp.add(tmpFood);
				cuisineToFood.put(cuisines[i],tmp);
			}
		}
	}

	public void changeRating(String food, int newRating) {
		Food f = foodToCuisine.get(food);
		cuisineToFood.get(f.cuisine).remove(f); // remove的时候参数填对应的object，object通过Food name来索引
		f.rate = newRating;
		cuisineToFood.get(f.cuisine).add(f);
	}

	public String highestRated(String cuisine) {
		return cuisineToFood.get(cuisine).peek().name;
	}
}
