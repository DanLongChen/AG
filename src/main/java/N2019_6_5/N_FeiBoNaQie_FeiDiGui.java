package N2019_6_5;

import java.util.Stack;

/**
 * Created by DanLongChen on 2019/6/5
 * 斐波那契非递归实现
 **/
public class N_FeiBoNaQie_FeiDiGui {
    public int handler(int n){
        /**
         * 根据0,1计算出2；根据1,2计算出3
         */
        if (n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int first=0;
        int second=1;
        int last=0;
        for (int i=2;i<=n;i++){
            last=first+second;
            first=second;
            second=last;
        }
        return last;
    }
    public int digui(int n){
        if (n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return digui(n-1)+digui(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new N_FeiBoNaQie_FeiDiGui().digui(4));
        Stack<Object> stack = new Stack<>();
        stack.push(1);
    }
}
