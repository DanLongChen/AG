package L2019_5_18;

/**
 * Created by DanLongChen on 2019/5/18
 **/

import java.util.Stack;

/**
 * 使用栈模拟队列
 */
public class MyQueue {
    Stack<Integer> stack=null;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp=new Stack<>();
        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }
        temp.push(x);
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
