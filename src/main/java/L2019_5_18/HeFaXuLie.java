package L2019_5_18;

/**
 * Created by DanLongChen on 2019/5/18
 **/

import java.util.Stack;

/**
 * 判断一个序列的栈的出栈顺序是否合法
 */
public class HeFaXuLie {
    public static void main(String[] args) {
        int[] sequance={3,2,5,4,1};
        System.out.println(isLegel(sequance,5));
    }

    /**
     *
     * @param sequance  出栈序列
     * @param n         整个序列的大小
     * @return
     */
    public static boolean isLegel(int[] sequance,int n){
        Stack<Integer> stack = new Stack<>();
        int index=0;//用于指示sequance
        for (int i=1;i<=n;i++){
            stack.push(i);
            while (!stack.isEmpty() && stack.peek()==sequance[index]){
                stack.pop();
                index++;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
