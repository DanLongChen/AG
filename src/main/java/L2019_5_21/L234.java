package L2019_5_21;

/**
 * Created by DanLongChen on 2019/5/21
 **/

import L2019_4_1.L23;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，判断其是否是回文
 */
public class L234 {
    public static void main(String[] args) {
        ListNode head=new ListNode(-129);
        head.next=new ListNode(-129);
        System.out.println(new L234().isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        System.out.println(list.toString());
        int i=0,j=list.size()-1;
        while (i<j){
            System.out.println(i+" "+j);
            if (list.get(i).equals(list.get(j))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
