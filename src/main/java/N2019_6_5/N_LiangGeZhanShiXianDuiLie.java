package N2019_6_5;

import java.sql.SQLOutput;
import java.util.Stack;

/**
 * Created by DanLongChen on 2019/6/5
 **/
public class N_LiangGeZhanShiXianDuiLie {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack2.size()<=0){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            System.out.println("对了空了！");
            return 0;
        }
        return stack2.pop();
    }
}
