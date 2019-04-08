package L2019_4_8;

import java.util.List;

/**右旋链表(倒数第k个以及之后的会被移动到最前面)
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * Created by DanLongChen on 2019/4/8
 **/
public class L61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || k==0){
            System.out.println("aaa");
            return head;
        }
        /**
         * 首先应该建立一个头结点,一个p指针，每一都要重新移动到末尾，然后把末尾的节点插入到头结点
         */
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode p=head;
        int length=0;
        /**
         * 计算长度
         */
        while (p!=null){
            length++;
            p=p.next;
        }
        p=head;
        int start=length-k%length;//从第几个开始的节点需要插入到头结点
        System.out.println(length+"   "+start);
        for (int i=1;i<start;i++){//移到需要右移节点的前驱
            p=p.next;
        }
        ListNode q=result;
        while (p.next!=null){
            ListNode temp=p.next;
            p.next=p.next.next;
            temp.next=q.next;
            q.next=temp;
            q=q.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(0);
        ListNode p=listNode;
        for(int i=1;i<=2;i++){
            ListNode temp=new ListNode(i);
            p.next=temp;
            p=p.next;
        }
        ListNode result=new L61().rotateRight(listNode,4);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
