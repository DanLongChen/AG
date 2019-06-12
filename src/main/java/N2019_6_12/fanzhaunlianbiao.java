package N2019_6_12;

/**
 * Created by DanLongChen on 2019/6/12
 **/
public class fanzhaunlianbiao {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        //使用头插法
        if (head==null || head.next==null){
            if(head==null)
            return null;
            return head;

        }
        ListNode newHead=null;
        ListNode next=null;
        while (head!=null){
            next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
}
