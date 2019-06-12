package N2019_6_12;

/**
 * Created by DanLongChen on 2019/6/12
 * 删除链表中的重复节点
 *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 **/
public class shanchulianbiaozhongchongfujiedian {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode node = pHead;
        ListNode pre=null;
        while (node!=null){
            if (node.next!=null && node.val==node.next.val){
                int temp=node.val;
                while(node!=null && node.val==temp){
                    node=node.next;
                }
                if (pre==null){//这种情况是最前面几个都是重复的情况
                    pHead=node;
                }else{
                    pre.next=node;
                }
            }else{
                pre=node;
                node=node.next;
            }
        }
        return pHead;
    }
}
