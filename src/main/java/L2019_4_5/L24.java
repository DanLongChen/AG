package L2019_4_5;

/**对链表进行两两互换 Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Created by Paser on 2019/4/5.
 */
public class L24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){//说明只有head一个
            return head;
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=head;
        ListNode next=cur.next;
        head=next;
        while(next!=null){
            pre.next=next;
            cur.next=next.next;
            next.next=cur;
            if(cur.next!=null && cur.next.next!=null){//说明有偶数个
                pre=cur;
                cur=cur.next;
                next=cur.next;
            }else{
                break;
            }
        }
        return head;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode p=head;
        for(int i=2;i<=4;i++){
            ListNode temp=new ListNode(i);
            p.next=temp;
            p=p.next;
        }
        new L24().swapPairs(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
