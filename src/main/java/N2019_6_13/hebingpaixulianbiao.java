package N2019_6_13;

/**
 * Created by DanLongChen on 2019/6/13
 * 合并两个排序链表
 **/
public class hebingpaixulianbiao {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode newHead=null;
        if(list1.val<list2.val){
            newHead=list1;
            list1=list1.next;
        }else{
            newHead=list2;
            list2=list2.next;
        }
        ListNode p=newHead;
        ListNode temp=null;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp=list1;
                list1=list1.next;
            }else{
                temp=list2;
                list2=list2.next;
            }
            p.next=temp;
            p=p.next;
        }
        while (list1!=null){
            temp=list1;
            list1=list1.next;
            p.next=temp;
            p=p.next;
        }
        while (list2!=null){
            temp=list2;
            list2=list2.next;
            p.next=temp;
            p=p.next;
        }
        return newHead;
    }
}
