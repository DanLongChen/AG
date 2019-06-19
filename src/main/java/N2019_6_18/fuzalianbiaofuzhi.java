package N2019_6_18;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by DanLongChen on 2019/6/18
 * 复杂链表复制
 **/
public class fuzalianbiaofuzhi {
    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        /**
         * 使用hashMap记录两条链之间的映射关系
         */
        HashMap<RandomListNode,RandomListNode> OldToNew=new HashMap<>();
        HashMap<RandomListNode,RandomListNode> NewToOld=new HashMap<>();
        RandomListNode p=pHead;
        RandomListNode newHead=new RandomListNode(0);
        RandomListNode q=newHead;
        while (p!=null){
            q.next=new RandomListNode(p.label);
            q=q.next;
            OldToNew.put(p,q);
            NewToOld.put(q,p);
            p=p.next;
        }
        p=pHead;
        q=newHead.next;
        while (p!=null){
            RandomListNode temp=p.random;
            q.random=OldToNew.get(temp);
            p=p.next;
            q=q.next;
        }
        return newHead.next;

    }
    public RandomListNode Clone2(RandomListNode pHead){
        /**
         * 第二种方法的话，先把复制的每一个节点接在原节点的后面，调配好random指针，然后再进行拆分
         */
        //第一步：插入新元素
        RandomListNode p=pHead;
        while (p!=null){
            RandomListNode temp=new RandomListNode(p.label);
            temp.next=p.next;
            p.next=temp;
            p=p.next.next;

        }
        //第二步：对新插入的节点修改random指针
        p=pHead;
        while (p!=null){
            p.next.random=p.random==null?null:p.random.next;
            p=p.next.next;
        }
        //第三步：分离新链表
        RandomListNode newHead=new RandomListNode(0);
        p=pHead;
        RandomListNode newHeadHandler=newHead;
        while (p!=null){
            newHeadHandler.next=p.next;
            p.next=p.next.next;
            newHeadHandler=newHeadHandler.next;
        }
        return newHead.next;
    }
}
