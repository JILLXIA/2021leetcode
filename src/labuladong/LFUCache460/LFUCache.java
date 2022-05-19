package labuladong.LFUCache460;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LFUCache {
	HashMap<Integer,Integer> keyToValue;
	HashMap<Integer, Integer> keyToFreq;
	HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
	int capacity;
	int minFreq;
	public LFUCache(int capacity) {
		this.capacity = capacity;
		keyToValue = new HashMap<>();
		keyToFreq = new HashMap<>();
		freqToKey = new HashMap<>();
	}

	public int get(int key) {
		if(!keyToValue.containsKey(key)){
			return -1;
		}
		// change the keyToFreq && freqToKey
		addKeyFreq(key);
		return keyToValue.get(key);
	}

	public void removeMinFreqKey(){
		LinkedHashSet<Integer> tmpSet = freqToKey.get(this.minFreq);
		int keyRemove = tmpSet.iterator().next(); // 找到首部第一个
		keyToValue.remove(keyRemove);
		keyToFreq.remove(keyRemove);
		tmpSet.remove(keyRemove);
		if(tmpSet.isEmpty()){
			freqToKey.remove(this.minFreq);
		}
	}

	public void addKeyFreq(int key){
		int tmpFreq = keyToFreq.get(key);
		keyToFreq.put(key,tmpFreq+1);
		freqToKey.get(tmpFreq).remove(key);
		freqToKey.putIfAbsent(tmpFreq+1,new LinkedHashSet<>());
		freqToKey.get(tmpFreq+1).add(key);
		if(freqToKey.get(tmpFreq).isEmpty()){
			freqToKey.remove(tmpFreq);
			if(tmpFreq==this.minFreq){
				this.minFreq = tmpFreq+1;
			}
		}
	}

	public void put(int key, int value) {
		if(this.capacity<=0){
			return;
		}
		if(keyToValue.containsKey(key)){
			// remove the key in freqToKey
			// change the keyToFreq
			// insert freq in freqToKey
			keyToValue.put(key,value);
			addKeyFreq(key);
			return;
		} else {
			if(keyToValue.size()==capacity){
				// remove the least freq
				removeMinFreqKey();
			}
		}

		int freqRefresh = keyToFreq.getOrDefault(key,0)+1;
		keyToValue.put(key,value);
		keyToFreq.put(key,freqRefresh);
		freqToKey.putIfAbsent(freqRefresh,new LinkedHashSet<>());
		freqToKey.get(freqRefresh).add(key);
		this.minFreq = 1;
	}
}
