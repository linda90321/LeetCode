import java.util.HashMap;

/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Hide Company Tags Google Uber Facebook Twitter Zenefits Amazon Microsoft Snapchat Yahoo Bloomberg Palantir
Hide Tags Design

*/
class DoubleLinkedList{
    int key;
    int val;
    DoubleLinkedList pre;
    DoubleLinkedList next;
    
    public DoubleLinkedList(int key, int val){
        this.key = key;
        this.val = val;
    }
}
public class LRUCache146 {
    private DoubleLinkedList head;
    private DoubleLinkedList end;
    private int capacity;
    private int length;
    private HashMap<Integer, DoubleLinkedList> map = new HashMap<Integer, DoubleLinkedList>();
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        length = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedList cur = map.get(key);
            removeNode(cur);
            setHead(cur);
            return cur.val;
        }
        
        return -1;
    }
    
    public void removeNode(DoubleLinkedList node){
        DoubleLinkedList cur = node;
        DoubleLinkedList pre = cur.pre;
        DoubleLinkedList post = cur.next;
        
        if(pre != null){
            pre.next = post;
        }else{
            head = post;
        }
        
        if(post != null){
            post.pre = pre;
        }else{
            end = pre;
        }
    }
    
    public void setHead(DoubleLinkedList node){
        if(head != null){
        node.pre = null;
        node.next = head;
        head.pre=node;
        head = node;
        }else if(head == null){
        head = node;
        }
        
        if(end == null)
        end = node;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedList cur = map.get(key);
            cur.val = value;
            removeNode(cur);
            setHead(cur);
        }else{
            DoubleLinkedList newNode = new DoubleLinkedList(key, value);
            if(length < capacity){
                map.put(key,newNode);
                setHead(newNode);
                length++;
            }else{
                map.remove(end.key);
                removeNode(end);
                setHead(newNode);
                map.put(key,newNode);
            }
        }
        
    }
}
