package L2019_4_1;

/**结合两个排序的链表，让结合之后的链表也是有序的
 * Created by DanLongChen on 2019/4/1
 **/
public class L21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode p=result;
        ListNode temp=new ListNode(0);
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp=new ListNode(l1.val);
                p.next=temp;
                p=p.next;
                l1=l1.next;
            }else{
                temp=new ListNode(l2.val);
                p.next=temp;
                p=p.next;
                l2=l2.next;
            }
        }
        while (l1!=null){
            p.next=l1;
            l1=l1.next;
            p=p.next;
        }
        while (l2!=null){
            p.next=l2;
            l2=l2.next;
            p=p.next;
        }
        return result.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
