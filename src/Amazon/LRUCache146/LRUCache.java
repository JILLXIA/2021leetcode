package Amazon.LRUCache146;

import java.util.LinkedHashMap;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {
    // key - value
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        // no key in this linked
        if(!linkedHashMap.containsKey(key)){
            return -1;
        }
        // linkedHashMap的直接赋值保留了原来的顺序
        int value = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        if(linkedHashMap.size() < capacity){
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
        } else {
            if(linkedHashMap.containsKey(key)){
                // 在原来的基础上修改
                linkedHashMap.remove(key);
                linkedHashMap.put(key,value);
            } else {
                // 去掉第一个元素
                linkedHashMap.remove(linkedHashMap.entrySet().iterator().next().getKey());
                linkedHashMap.put(key,value);
            }
        }
    }
}
