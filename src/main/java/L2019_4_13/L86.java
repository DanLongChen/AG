package L2019_4_13;

/**给定一个数，将链表中的数按照给定的数进行分区，并且应该保持分区之前的先后顺序
 * Created by Paser on 2019/4/13.
 */
public class L86 {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return head;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode p=result;//头插法的指针
        ListNode pre=p;//用于寻找链表元素的指针(先从head开始)
        ListNode temp=new ListNode(0);
        if (head.val<x){
            System.out.println("<x");
            p=p.next;
            pre=pre.next;
        }
        while (pre.next!=null){
            if (pre.next.val<x){
                System.out.println("if"+"   "+pre.next.val);
                /**
                 * 摘除操作
                 */
                temp=pre.next;
                pre.next=temp.next;
                /**
                 * 插入操作
                 */
                temp.next=p.next;
                p.next=temp;
                p=p.next;
            }else {
                pre=pre.next;
            }
        }
        return result.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode p=head;
        int[] nums={1};
        for (int i=0;i<nums.length;i++){
            ListNode temp=new ListNode(nums[i]);
            p.next=temp;
            p=p.next;
        }
        ListNode result=new L86().partition(head,2);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
