package com.bademo.jeight.structure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created Info: LinkedHashMap实现LRU算法
 * LRU:如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小
 * User: dota.liu.bin@gmail.com
 * Date: 2017/8/17 0017.15:12
 */
public class LRUAchieveTest {

    public static void main(String[] args) {
        //initialCapacity   初始容量
        //loadFactor    加载因子，一般是 0.75f
        //accessOrder   false 基于插入顺序  true  基于访问顺序（get一个元素后，这个元素被加到最后，使用了LRU  最近最少被使用的调度算法）
        /*Map<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 9);
        map.put(4, 4);
        map.put(5, 7);
        map.put(6, 9);
        map.get(3); //访问的元素会放到链表最后
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next().getKey());
        }*/

        Map<Integer,Integer> mapLru=new LRULinkedHashMap<>(4);
        mapLru.put(11,3);
        mapLru.put(12,4);
        mapLru.put(13,9);
        mapLru.put(14,4);
        mapLru.put(15,6);
        for(Map.Entry<Integer, Integer> lru : mapLru.entrySet()){
            System.out.println(lru.getKey()+" "+lru.getValue());
        }
    }
}

//扩展一下LinkedHashMap这个类，让他实现LRU算法
class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    //定义缓存的容量
    private int capacity;
    private static final long serialVersionUID = 1L;

    //带参数的构造器
    LRULinkedHashMap(int capacity) {
        //调用LinkedHashMap的构造器，传入以下参数
        super(16, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //System.out.println(eldest.getKey() + "=" + eldest.getValue());
        return size() > capacity;
    }
}
