package L2019_7_14;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paser on 2019/7/14.
 * 设计一个LRU缓存
 */
public class L146 {
    /**
     * 使用hashMap+双向链表;热点数据放置在头部，冷数据放在尾部（每一次访问的时候，都将这个数据放在头部）
     */
    class DLinkNode{
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
    }
    private void addNode(DLinkNode node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;

    }
    private void removeNode(DLinkNode node){
        DLinkNode pre=node.pre;
        DLinkNode next=node.next;
        pre.next=next;
        next.pre=pre;
    }
    private void moveToHead(DLinkNode node){
        removeNode(node);
        addNode(node);
    }
    private DLinkNode removeTail(){
       DLinkNode temp=tail.pre;
       removeNode(temp);
       return temp;
    }
    private DLinkNode head;
    private DLinkNode tail;
    private Map<Integer,DLinkNode> cache=new HashMap<>();
    private int size=0;
    private int capacity=0;
    public L146(int capacity) {
       this.capacity=capacity;
       head=new DLinkNode();
       tail=new DLinkNode();
       head.next=tail;
       tail.pre=head;
    }

    public int get(int key) {
        DLinkNode temp=cache.get(key);
        if(temp==null){
            return -1;
        }
        moveToHead(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        DLinkNode temp=cache.get(key);
        if(temp==null){
            DLinkNode newNode=new DLinkNode();
            newNode.value=value;
            newNode.key=key;
            cache.put(key,newNode);
            addNode(newNode);
            size++;
            if(size>capacity){
                DLinkNode removeNode=removeTail();
                cache.remove(removeNode.key);
                size--;
            }
        }else{
            temp.value=value;
            moveToHead(temp);
        }
    }
}
