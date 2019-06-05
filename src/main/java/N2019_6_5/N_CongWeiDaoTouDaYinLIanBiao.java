package N2019_6_5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/6/5
 * 从尾到头打印链表
 **/
public class N_CongWeiDaoTouDaYinLIanBiao {
    private class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /**
         * 第一种方法可以使用栈，这个比较简单，就不演示了
         */
        /**
         * 第二种方法是使用递归
         */
        ArrayList<Integer> list = new ArrayList<>();
        handler(list,listNode);
        return list;
    }
    public void handler(List list,ListNode listNode){
        if (listNode==null){
            return;
        }
        handler(list,listNode.next);
        list.add(listNode.val);
    }

    public static void main(String[] args) {

    }
}
