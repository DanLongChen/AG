package L2019_4_13;

/**
 * Created by Paser on 2019/4/13.
 */
public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        /**
         * 给定一个pre和cur，若元素相同则直接跳过
         */
        ListNode result=new ListNode(0);
        ListNode pre=result;
        pre.next=head;
        ListNode cur=pre.next;
        while (cur!=null && cur.next!=null){
            if (cur.val==cur.next.val){
                while (cur!=null && cur.val==pre.next.val){
                    cur=cur.next;
                }
                pre.next=cur;
            }else{
                cur=cur.next;
                pre=pre.next;
            }
        }
        return result.next;

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
