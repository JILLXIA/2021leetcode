package labuladong.InsertDeleteGetRandomO1380;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class RandomizedSet {
	//  这种做法会超时，底层是数组取随机值更快
	LinkedHashSet<Integer> lhs;
	Random rd;
	public RandomizedSet() {
		lhs = new LinkedHashSet<>();
		rd = new Random();
	}

	public boolean insert(int val) {
		if(!lhs.contains(val)){
			lhs.add(val);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if(!lhs.contains(val)){
			lhs.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		Iterator<Integer> it = lhs.iterator();
		int result = 0;
		int i = 1;
		while(it.hasNext()){
			if(rd.nextInt(i)==0){
				result = it.next();
			}
			i++;
		}
		return result;
	}
}
