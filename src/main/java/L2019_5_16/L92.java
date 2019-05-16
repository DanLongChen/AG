package L2019_5_16;

/**
 * Created by DanLongChen on 2019/5/16
 **/
public class L92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return head;
        }
        int changeLength=n-m+1;
        ListNode result=head;
        ListNode pre=null;
        /**
         * 移动pre到m点的前驱，head到m点
         */
        while (head!=null && --m>0){
            pre=head;
            head=head.next;
        }
        ListNode modifyTail=head;
        ListNode newHead=null;//用于充当中间逆制之后链表的头结点
        ListNode next=head.next;
        while (head!=null && changeLength>0){
            next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        modifyTail.next=head;
        /**
         * 说明在第一个节点进行逆制
         */
        if (pre==null){
            result=newHead;
        }else{
            pre.next=newHead;
        }
        return result;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
