package L2019_6_26;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/6/26
 * 单链表做加法
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L2 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 思路1：配置进位，然后逐个相加
         */
        ListNode result=new ListNode(0);
        int n1=0,n2=0,move=0,sum=0;
        ListNode p=result;
        while(l1!=null || l2!=null){
            n1=l1==null?0:l1.val;
            n2=l2==null?0:l2.val;
            sum=n1+n2+move;
            move=sum>=10?1:0;
            p.next=new ListNode(sum%10);
            p=p.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(move==1){
            p.next=new ListNode(1);
        }
        return result.next;
    }

}
