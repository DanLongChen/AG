package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对链表进行排序，时间复杂度要求O(nlogn),空间复杂度为常量级别
 */
public class L148 {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        ListNode result=new ListNode(0);
        ListNode p=result;
        for (int i=0;i<list.size();i++){
            ListNode temp=new ListNode(list.get(i));
            p.next=temp;
            p=p.next;
        }
        return result.next;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
