package N2019_6_17;

import java.util.Stack;

/**
 * Created by DanLongChen on 2019/6/17
 * 栈的压入弹出序列（判断一个序列是不是栈的弹出序列）
 **/
public class zhandeyarutanchuxulie {
    private Stack<Integer> stack=new Stack<>();

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        System.out.println(new zhandeyarutanchuxulie().IsPopOrder(pushA,popA));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        /**
         * 可以创建一个辅助栈模拟栈的弹出过程，如果是栈顶元素和弹出序列匹配，那么进行下一个；如果不匹配那么就将压栈序列继续压栈，序列为空并且栈顶元素和出栈序列不匹配，则表示序列不匹配
         */
        if (pushA!=null && popA!=null && pushA.length>0 && popA.length>0 && pushA.length==popA.length){
            int indexOfPush=0;
            int indexOfPop=0;
            int length=pushA.length;
            for (indexOfPush=0;indexOfPush<length;indexOfPush++){
                stack.push(pushA[indexOfPush]);
                while (!stack.isEmpty() && indexOfPop<length && stack.peek()==popA[indexOfPop]){
                    stack.pop();
                    indexOfPop++;
                }
            }
        }
        return stack.isEmpty();
    }
}
