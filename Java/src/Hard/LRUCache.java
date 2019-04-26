package Hard;

import java.util.*;


/**
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return  cache.size() > capacity;
            }
        };
        this.capacity = capacity;
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        cache.put(key, value);
    }
}


/**
 *  * to be continued. I might have run into a bad path,
 *  * since priorityqueue can not achieve O(1)
 */
class LRUCache_ {
    Map<Integer, Long> itol;
    Map<Long, Integer> ltoi;
    PriorityQueue<Long> pq;
    private  static long sequence = 0;
    int cap;

    public LRUCache_(int capacity) {
        cap = capacity;
        itol = new HashMap<>();
        ltoi = new HashMap<>();
        pq = new PriorityQueue<>();
    }

    private static Long seq(){
        return ++ sequence;
    }

    public int get(int key) {
        if(itol.containsKey(key)){
            long newseq = seq();
            long oldseq = itol.get(key);
            ltoi.remove((oldseq));

            itol.put(key, newseq);
            ltoi.put(newseq, key);

            if(pq.size() == cap){
                pq.poll();
                pq.add(newseq);
            }
            return key;
        }
        return -1;
    }

    public void put(int key, int value) {
        Long tick = seq();
        if(itol.containsKey(key)){
            itol.put(key, tick);
            ltoi.put(tick, key);
            pq.add(tick);
            return;
        }

        if(itol.size() == cap){
            Long top = pq.poll();
            Integer val = ltoi.get(top);
            itol.remove(val);
            ltoi.remove(top);
        }
        itol.put(key, tick);
        ltoi.put(tick, key);
        pq.add(tick);
    }
}
