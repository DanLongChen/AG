package N2019_6_12;

import java.util.List;

/**
 * Created by DanLongChen on 2019/6/12
 * 输出链表中的倒数第K个节点
 **/
public class lianbiaozhongdedaoshuKgejiedian {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        /**
         * 第一种方式：先便利整个链表，记录长度，然后从头数n-k+1个节点就是倒数的第K个节点
         * 第二种方式：使用前后指针，两个指针之间的间隔为K，当前一个指针到达末尾的时候，第二个指针刚好指向倒数第K个节点
         */
        ListNode first=head;
        ListNode second=null;
        int index=1;
        while (first!=null){
            if (index<=k){
                index++;
                first=first.next;
            }else{
                if (second==null){
                    second=head;
                }
                second=second.next;
                first=first.next;
            }
        }
        return second;
    }

    public static void main(String[] args) {

    }
}
