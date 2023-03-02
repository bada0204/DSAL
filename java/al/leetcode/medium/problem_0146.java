/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 1. LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * 2. int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * 3. void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key
 * 
 * The functions get and put must each run in O(1) average time complexity.
 */

package al.leetcode.medium;

import java.util.LinkedHashMap;

public class problem_0146 {

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public problem_0146(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int val = -1;
        if (this.cache.containsKey(key)) {
            val = this.cache.get(key);
            this.refresh(key, val);
        }
        return val;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.cache.remove(key);
        } else if (this.cache.size() == this.capacity) {
            int lru = this.cache.entrySet().iterator().next().getKey();
            this.cache.remove(lru);
        }
        this.cache.put(key, value);
    }

    public void refresh(int key, int value) {
        this.cache.remove(key);
        this.cache.put(key, value);
    }
    
}
