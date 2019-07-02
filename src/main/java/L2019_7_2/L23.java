package L2019_7_2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by DanLongChen on 2019/7/2
 * 合并k个排序链表
 **/
public class L23 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 解法1：暴力法：可以将k个排序链表中的元素全部记录下来，进行排序，然后再产生新的链表
     */
    /**
     * 解法2：使用优先队列，每次都从优先队列里面取最小的，然后再将这个最小值的下一个节点放入优先队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val<o2.val?-1:o1.val==o2.val?0:1;
            }
        });
        for(ListNode listNode:lists){
            if(listNode!=null){
                queue.add(listNode);
            }
        }
        ListNode result=new ListNode(0);
        ListNode p=result;
        while (!queue.isEmpty()){
            ListNode temp=queue.poll();
            p.next=temp;
            p=p.next;
            if(temp.next!=null){
                queue.add(temp.next);
            }
        }
        return result.next;
    }

    /**
     * 解法3：使用分治：将k个链表两两进行合并
     */
}
