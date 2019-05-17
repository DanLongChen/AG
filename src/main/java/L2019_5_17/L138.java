package L2019_5_17;

/**
 * Created by DanLongChen on 2019/5/17
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 深度拷贝有随机指针的链表
 */
public class L138 {
    public Node copyRandomList(Node head) {
        /**
         * 使用两个map分别存放Random地址和节点ID的对应关系（存放老链表），以及节点ID和Random地址的对应关系（存放新链表）
         */
        Node newHead=new Node(0,null,null);
        Node pHead=head;
        Node pnewHead=newHead;
        Map<Node,Integer> map1=new HashMap<>();
        Map<Integer,Node> map2=new HashMap<>();
        int index=1;
        while (pHead!=null){
            map1.put(pHead,index);
            pnewHead.next=new Node(pHead.val,null,null);
            map2.put(index,pnewHead.next);
            pnewHead=pnewHead.next;
            pHead=pHead.next;
            index++;
        }
        pHead=head;
        pnewHead=newHead.next;
        while (pHead!=null){
            if (pHead.random!=null){
                int point=map1.get(pHead.random);
                pnewHead.random=map2.get(point);
            }
            pHead=pHead.next;
            pnewHead=pnewHead.next;

        }
        return newHead.next;


    }
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
