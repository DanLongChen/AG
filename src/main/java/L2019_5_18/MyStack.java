package L2019_5_18;

/**
 * Created by DanLongChen on 2019/5/18
 **/

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class MyStack {
    LinkedList<Integer> queue=null;
    /** Initialize your data structure here. */
    public MyStack() {
        queue=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        int temp=queue.removeLast();
        queue.offer(temp);
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
