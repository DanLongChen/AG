package N2019_6_17;

import java.util.Stack;

/**
 * Created by DanLongChen on 2019/6/17
 * 含min函数的栈
 **/
public class hanMinhanshudezhan {
    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> min=new Stack<>();
    private int minValue=Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if (node<=minValue){
            minValue=node;
        }

        min.push(minValue);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
