package L2019_4_11;

/**给定一个排序号的列表，删除重复的数据
 * Created by DanLongChen on 2019/4/11
 **/
public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p=head;
        while (p.next!=null){
            if(p.val==p.next.val){//两个相邻点的数据相同
                p.next=p.next.next;
            }else{
                p=p.next;
            }
        }
        return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
