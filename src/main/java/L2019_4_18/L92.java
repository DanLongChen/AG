package L2019_4_18;

/**给定一个范围，反转范围内的链表元素
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * Created by DanLongChen on 2019/4/18
 **/
public class L92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /**
         * 自己单独创一条链，然后返回这条链（在m~n的范围内的使用头插法，不在范围内的使用尾插法）,应该是可以用一次循环解决的
         */
        /**
         * 首先需要找到边界指针(从1开始计数)
         */
        if (head==null){
            return head;
        }
        ListNode p=head;
        ListNode result=new ListNode(0);//带头结点的链表
        ListNode q=result;//指向末尾，尾插的位置
        ListNode pre=result;//指向头插的位置
        ListNode temp=new ListNode(0);
        int index=0;
        boolean flag=false;
        while (p!=null){
            /**
             * 说明到了需要反转的区域，头部插入
             */
            index++;
            temp=new ListNode(p.val);
            p=p.next;
            if (index>=m && index<=n){
                temp.next=pre.next;
                pre.next=temp;
                if (flag==false)//尾指针在尾插的时候需要一直移动，在前插的时候只能移动一次
                {
                    q=q.next;//尾指针也是要移动的
                    flag=true;
                }
            }else{
                q.next=temp;
                q=q.next;
                pre=q;
            }
        }
        System.out.println("hello");
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode p=head;
        int[] nums={2,3,4,5};
        for (int i:nums){
            ListNode temp=new ListNode(i);
            p.next=temp;
            p=p.next;
        }
        ListNode result=new L92().reverseBetween(head,1,4);
        p=result;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }

 static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
