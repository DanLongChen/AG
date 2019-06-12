package N2019_6_12;

/**
 * Created by DanLongChen on 2019/6/12
 * 链表中环的入口节点
 **/
public class lianbiaozhonghuanderukoujiedian {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        /**
         * 方法一：使用set
         * 方法二：快慢指针（一个走一步，一个走两步）
         */
        if (pHead==null){
            return null;
        }
        ListNode slow=pHead;
        ListNode quick=pHead;
       while (quick!=null && quick.next!=null){
           slow=slow.next;
           quick=quick.next.next;
           if(slow==quick){
               ListNode p=pHead;
               while (p!=slow){
                   p=p.next;
                   slow=slow.next;
               }
               return p;
           }
       }
       return null;
    }
}
