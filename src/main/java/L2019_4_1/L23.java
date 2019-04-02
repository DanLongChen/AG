package L2019_4_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**合并K个排序好的链表（按照原来的次序）
 * Created by DanLongChen on 2019/4/1
 **/
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        /**
         * 首先将每一个数都放进list，然后再进行排序，再输出
         */
        for(int i=0;i<lists.length;i++){
            while(lists[i]!=null){
                list.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        Collections.sort(list);
        ListNode result=new ListNode(0);
        ListNode p=result;
        for(int i=0;i<list.size();i++){
            ListNode temp=new ListNode(list.get(i));
            p.next=temp;
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
