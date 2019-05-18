package L2019_5_18;

/**
 * Created by DanLongChen on 2019/5/18
 **/

import java.util.Stack;

/**
 * 包含最小值的栈，要求所有的操作都是O(1)
 */
public class MinStack {
    /**
     * 可以设置一个变量在插入的时候就记录最小值
     */
    Stack<Integer> stack = null;
    Stack<Integer> minStack=null;//用于对应stack的最小值
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
        minStack=new Stack<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if (x<minStack.peek()){
            minStack.push(x);
        }else{
            minStack.push(minStack.peek());
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
