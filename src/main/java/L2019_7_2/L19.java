package L2019_7_2;

import java.util.Stack;

/**
 * Created by DanLongChen on 2019/7/2
 * 删除链表中倒数第n个节点
 **/
public class L19 {

      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //分两次循环，首先计算总长度，然后计算一下走多少步到倒数第n个的前驱，再循环使得指针指向那个前驱，再执行删除

            if(head==null || n==0){
                return head;
            }
            int length=0;
            ListNode p=head;
            while(p!=null){
                p=p.next;
                length++;
            }
            if(length==n){//表示删除第一个元素
                return head.next;
            }
            int jump=length-n-1;//计算需要的跳数
            p=head;
            for(int i=0;i<jump;i++){
                p=p.next;
            }
            if(p.next!=null)
                p.next=p.next.next;
            return head;

        }
    }
}
