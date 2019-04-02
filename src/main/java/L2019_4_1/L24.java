package L2019_4_1;

/**两两反转链表的值，Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Created by DanLongChen on 2019/4/1
 **/
public class L24 {
    public ListNode swapPairs(ListNode head) {
        /**
         * 说明为空或者只有一个数据的情况
         */
        if(head==null || head.next==null){
            return head;
        }
        /**
         * 下面是有两个或者以上数据的情况
         */
        ListNode p=head;//定义前后指针
        ListNode q=head.next;
        ListNode next=q.next;
        head=head.next;//head往后移动一位，因为1,2肯定是要互换的
        if(next==null){
            q.next=p;
            return head;
        }
        while(true){
            System.out.println("haha");
            q.next=p;
            if(next!=null && next.next!=null){
                p.next=next.next;
            }else{
                p.next=next;
            }
            p=next;
            if(p!=null){
                q=p.next;
            }else{
                break;
            }
            if(q!=null){
                next=q.next;
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
        for (int i=2;i<=5;i++){
            ListNode temp=new ListNode(i);
            p.next=temp;
            p=p.next;
        }
        ListNode result=new L24().swapPairs(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
