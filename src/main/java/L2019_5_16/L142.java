package L2019_5_16;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/5/16
 * 判断节点是否有环，如果有则返回环的起始节点，如果没有返回null
 **/
public class L142 {
    public ListNode detectCycle(ListNode head) {
        /**
         * 第一种：使用set，放入链表的全部节点，若有环则会重复
         */
//        Set<ListNode> set = new HashSet<>();
//        while (head!=null){
//            if(set.contains(head)){
//                return head;
//            }
//            set.add(head);
//            head=head.next;
//        }
//        return null;
        /**
         * 第二种方法，快慢指针
         */
        ListNode slow=head;
        ListNode fast=head;
        ListNode meet=null;
        while (slow!=null && fast!=null){
            slow=slow.next;
            if(fast.next!=null){//需要判断是否是空指针
                fast=fast.next.next;
            }else{
                break;
            }

            if(slow==fast){
                meet=slow;
                break;
            }
        }
        if(meet==null){
            return null;
        }
        while (head!=null && meet!=null && head!=meet){//这里也需要做判空操作
            head=head.next;
            meet=meet.next;
        }
        return head;
    }
}
