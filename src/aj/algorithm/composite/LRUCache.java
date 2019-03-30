/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Refer: https://medium.com/@krishankantsinghal/my-first-blog-on-medium-583159139237
 */
package aj.algorithm.composite;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ajeet on 3/28/2019.
 */
class LRUCache<K,V> {
    class CacheEntry<K,V>{
        K key;
        V value;
        CacheEntry prev;
        CacheEntry next;
    }
    int maxSize;
    Map<K,CacheEntry<K,V>> map;
    CacheEntry<K,V> head = null;
    CacheEntry<K,V> tail = null;

    LRUCache(int maxSize){
        this.maxSize= maxSize;
        map = new HashMap<K,CacheEntry<K,V>>();
    }

    public synchronized void put(K key, V value){
        CacheEntry<K,V> entry;
        if(map.containsKey(key)){
            entry = map.get(key);
            entry.value= value;
            removeNode(entry);
        } else {
            entry = new CacheEntry<K,V>();
            entry.key = key;
            entry.value = value;
            if(map.size() == maxSize){
                map.remove(removeNode(tail));
            }
            map.put(key, entry);
        }
        addToFront(entry); //todo

    }
    public V get(K key){
        if(map.containsKey(key)){
            CacheEntry<K,V> entry = map.get(key);
            synchronized(entry) {
                removeNode(entry);
                addToFront(entry);
            }
            return entry.value;
        } else
            return null;
    }

    private K removeNode(CacheEntry<K,V> entry) {
        K key = entry.key;
        CacheEntry<K,V> prev = entry.prev;
        if(prev !=  null) {
            prev.next = entry.next;
        }
        CacheEntry<K,V> next = entry.next;
        if(next != null) {
            next.prev = entry.prev;
        }
        return key;
    }

    private void addToFront(CacheEntry<K,V> entry) {
        if(head == null){
            head = entry;
            tail = entry;
        } else {
            entry.next = head;
            head = entry;

        }
    }



    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");
        cache.put(4,"d");

        System.out.println("cache.get(3) = " + cache.get(3));
        System.out.println("cache.get(2) = " + cache.get(2));
        System.out.println("cache.get(1) = " + cache.get(1));

    }
}

