package ACM.tag刷题.算法.设计;

import java.util.*;

public class design_146LRU缓存机制 {
    /***
     运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     实现 LRUCache 类：

     LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     进阶:O{1}时间复杂度
     */
    public static void main(String[] args) {
        /*LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));//1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));//-1
        System.out.println("----------------------开始put4");
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println("----------------end");
        System.out.println(lRUCache.get(1));//-1
        System.out.println(lRUCache.get(3));//3
        System.out.println(lRUCache.get(4));//4*/
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(1));
    }

}

/***
 方法:用哈希表+双向链表 使用伪头结点 尾结点
 */
class LRUCache {

    //Deque<Integer> deque = new LinkedList<>();
    //Deque实现
    //优先队列实现 PrioriQueue
    //map + listNode实现

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    ListNode head;
    ListNode per;
    int maxSize;
    int size;
    Map<Integer, ListNode> map;
    int one[];

    public LRUCache(int capacity) {
        if (capacity == 1) one = new int[2];
        head = new ListNode();
        map = new HashMap<>();
        this.maxSize = capacity;
        size = 0;
        per = new ListNode();
        per = head;
    }

    public int get(int key) {
        if (maxSize == 1) {
            if (one[0] == key && size == 1) {
                return one[1];
            } else {
                return -1;
            }
        }
        //System.out.println("这是head="+head);
        //有则返回,无则直接-1
        //将get(key)的key指定优先级最高
        if (!map.containsKey(key)) {
            return -1;
        } else {
            if (map.get(key).val == -1) return -1;
            //System.out.println("=-------------"+head);
            ListNode p = map.get(key);
            //System.out.println(p);
            //将p的优先级提最高
            ListNode cur = new ListNode();
            cur = head;
            while (cur.next != p) {
                cur = cur.next;
            }
            //System.out.println(cur);
            cur.next = cur.next.next;
            p.next = null;
            per.next = p;
            per = per.next;
            //System.out.println(head+"-----------");
            return p.val;
        }
    }

    public void put(int key, int value) {
        if (maxSize == 1) {
            one[0] = key;
            one[1] = value;
            size = 1;
        } else {


            //将put的值优先级最高
            //检查是否size满,满去一个优先级最低的值
            //如果map中有了这个key,value
            if (map.containsKey(key)) {
                ListNode p = map.get(key);
                p.val = value;
                //将p的优先级提最高
                ListNode cur = new ListNode();
                cur = head;
                while (cur.next != p) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                p.next = null;
                per.next = p;
                per = per.next;
            } else {
                ListNode p = new ListNode(value);
            /*if (head.next == null) {
                head.next = p;
                //p.val=-1;
                per=head.next;
            } else {*/
                if (size == maxSize) {
                    // System.out.println("这是2"+head.next);
                    //map.remove(head.next);
                    //System.out.println(map);
                    head.next.val = -1;
                    head.next = head.next.next;
                    per.next = p;
                    per = per.next;
                } else {
                    //没满
                    //System.out.println("-------------直接在后面加了"+key+"size="+size+"maxsize="+maxSize);
                    per.next = p;
                    per = per.next;
                    size++;
                }
                //}
                map.put(key, p);

            }
        }
    }
}

//93 65
class LRUCache2 extends LinkedHashMap<Integer,Integer>{
    private int capacity;
    public LRUCache2(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {//删除的条件是size大于了最大长度
        return this.size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */