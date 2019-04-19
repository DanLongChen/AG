package L2019_4_13;

/**删除重复的数，留下唯一的
 * Created by Paser on 2019/4/13.
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 */
public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 给定一前一后指针，跳过相同的数字，字节链接到不相同的数字上
         */
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
            }else{//当cur的当前一步和下一步不相同的时候，两个指针才同时往下移动
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
