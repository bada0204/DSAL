/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * 
 * Implement the LFUCache class:
 * 1. LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * 2. int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * 3. void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. 
 * When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
 * For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * 
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. 
 * The key with the smallest use counter is the least frequently used key.
 * 
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). 
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 */

package al.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class problem_0460 {

    private int capacity;
    private int minFrequency;
    private Map<Integer, int[]> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencies;

    public problem_0460(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
    }
    
    public int get(int key) {
        if (this.cache.containsKey(key)) {
            this.incrementCount(key);
            return this.cache.get(key)[0];
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.incrementCount(key);
            this.cache.get(key)[0] = value;
        } else {
            if (cache.size() >= this.capacity) {
                LinkedHashSet<Integer> lfu = this.frequencies.get(this.minFrequency);
                int lru = lfu.iterator().next();
                lfu.remove(lru);
                this.cache.remove(lru);
            }
            int[] info = new int[] {value, 1};
            this.cache.put(key, info);
            this.minFrequency = 1;
            this.frequencies.putIfAbsent(this.minFrequency, new LinkedHashSet<>());
            this.frequencies.get(this.minFrequency).add(key);
        }
    }

    private void incrementCount(int key) {
        int[] info = this.cache.get(key);
        this.frequencies.get(info[1]).remove(key);
        if (this.frequencies.get(this.minFrequency).isEmpty()) {
            this.minFrequency++;
        }
        info[1]++;
        this.frequencies.putIfAbsent(info[1], new LinkedHashSet<>());
        this.frequencies.get(info[1]).add(key);
    }
    
}
