package L2019_5_16;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/5/16
 * 给定两个链表，求两个链表第一个重合的节点
 **/
public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 第一种方法是将节点的地址放入到set中。
         * 首先便利ListA，然后将其节点地址放入set；
         * 便利ListB，然后判断地址是否在set中，第一个重复的地址就是交叉的节点
         */
//        Set<ListNode> set = new HashSet<>();
//        while (headA!=null){
//            set.add(headA);
//            headA=headA.next;
//        }
//        while (headB!=null){
//            if (set.contains(headB)){
//                return headB;
//            }
//            headB=headB.next;
//        }
//        return null;

        /**
         * 第二种方法
         * 首先计算两条链表的长度，然后让较长的链表指针先移动，移动到和较短链表等长的位置，然后两个链表一起移动，两个指针移动过程中节点相等的第一个节点就是所需的解
         */
        int lengthA=0;
        ListNode pA=headA;
        while (pA!=null){
            lengthA++;
            pA=pA.next;
        }
        int lengthB=0;
        ListNode pB=headB;
        while (pB!=null){
            lengthB++;
            pB=pB.next;
        }
        int dil=Math.abs(lengthA-lengthB);//计算两条链表长度的差值
        if (lengthA>lengthB){
            while (dil>0){
                dil--;
                headA=headA.next;
            }
            while (headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
            return headA;
        }else{
            while (dil>0){
                dil--;
                headB=headB.next;
            }
            while (headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
            return headA;
        }

    }
}
