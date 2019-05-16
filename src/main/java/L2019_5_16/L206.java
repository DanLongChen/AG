package L2019_5_16;

/**
 * Created by DanLongChen on 2019/5/16
 **/
public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode newNode=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=newNode;
            newNode=head;
            head=next;
        }
        return next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
