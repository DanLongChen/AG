package L2019_4_13;

/**给定一个数，将链表中的数按照给定的数进行分区，并且应该保持分区之前的先后顺序
 * Created by Paser on 2019/4/13.
 */
public class L86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        if (head!=null && head.next==null){
            return head;
        }
        /**
         * 将>x的元素插入到链表的最末尾，<x的元素直接跳过
         */
        /**
         * 需要一个指针用于标记尾指针，便利到尾指针的时候结束
         */
        ListNode tail=new ListNode(0);
        ListNode p=head;
        while (p!=null){//给尾指针找到末尾的位置
            tail=p;
            p=p.next;
        }
        p=tail;
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode q=result;
        ListNode temp=new ListNode(0);
        int num=0;
        while (q.next!=null && q.next!=tail){
            if (q.next.val<x){
                q=q.next;
            }else{
                temp=q.next;
                System.out.println("temp="+temp.val);
                q.next=q.next.next;
                p.next=temp;
                p=p.next;
            }
            System.out.println("nums="+(++num));
        }
        if (tail.val>=x && tail.next!=null){
            temp=tail;
            q.next=q.next.next;
            p.next=temp;
            p=p.next;
        }
        p.next=null;
        return result.next;

    }
    public ListNode partition2(ListNode head, int x) {
        /**
         * 将>x和<x的两类值分开处理（分别放置在两个链表中）
         */
        ListNode small=new ListNode(0);
        ListNode large=new ListNode(0);
        ListNode curS=small;
        ListNode curL=large;
        ListNode cur=new ListNode(0);
        cur.next=head;
        ListNode temp=head;
        while (cur.next!=null){
            if (cur.next.val<x){
                temp=cur.next;
                cur.next=cur.next.next;
                curS.next=temp;
                curS=curS.next;
                curS.next=null;
            }else{
                temp=cur.next;
                cur.next=cur.next.next;
                curL.next=temp;
                curL=curL.next;
                curL.next=null;
            }
        }
        curS.next=large.next;
        return small.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode p=head;
        int[] nums={4,3,2,5,2};
        for (int i=0;i<nums.length;i++){
            ListNode temp=new ListNode(nums[i]);
            p.next=temp;
            p=p.next;
        }
        ListNode result=new L86().partition2(head,3);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
