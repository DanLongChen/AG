package L2019_4_1;

/**移除链表中靠近末尾的第n个数，然后返回
 * Created by DanLongChen on 2019/4/1
 **/
public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        ListNode temp=head;
        /**
         * 首先求出链表长度
         */
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        if (length<n){
            return null;
        }
        int front=length-n;
        /**
         * 想要删除第一个的情况，直接返回head的next
         */
        if (front==0){
            return head.next;
        }
        temp=head;
        int count=1;
        while(count<front){
            temp=temp.next;
            count++;
        }
        if (temp.next!=null){
            temp.next=temp.next.next;
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
        for (int i=2;i<=5;i++){
            ListNode temp=new ListNode(i);
            p.next=temp;
            p=p.next;
        }
        ListNode result=new L19().removeNthFromEnd(head,2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
