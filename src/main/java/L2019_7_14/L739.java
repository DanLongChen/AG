package L2019_7_14;

import java.util.Stack;

/**
 * Created by Paser on 2019/7/14.
 * 每日温度
 */
public class L739 {

    public int[] dailyTemperatures(int[] T) {
        /**
         * 暴力破解
         */

        if(T==null || T.length==0){
            return new int[0];
        }
        int[] result=new int[T.length];
        out:
        for(int i=0;i<T.length;i++){
            int temp=T[i];
            for(int j=i+1;j<T.length;j++){
                if(T[j]>temp){
                    result[i]=j-i;
                    continue out;
                }
            }
            result[i]=0;
        }
        return result;
    }
    public int[] dailyTemperatures1(int[] T) {
        /**
         * 使用栈，从后往前便利，栈是非递减排序，栈顶是从后往前的那几天温度最低的
         */
        if(T==null || T.length==0){
            return new int[0];
        }
        int[] result=new int[T.length];
        Stack<Integer> stack=new Stack<>();
        for (int i=T.length-1;i>=0;i--){
            /**
             * 找一个比当前的温度要大的
             */
            while (!stack.isEmpty() && T[i]>=T[stack.peek()]){
                stack.pop();
            }
            int temp=stack.isEmpty()?0:stack.peek()-i;//找不到则说明后面已经没有比当前的温度还大的了，当前天的温度是最高的温度
            //那么前一天也没有继续往后找的必要了
            result[i]=temp;
            stack.push(i);
        }
        return result;
    }
}
