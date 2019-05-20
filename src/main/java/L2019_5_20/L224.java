package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

import java.util.Stack;

/**
 * 实现简单的计算器
 */
public class L224 {
    public static void main(String[] args) {
        System.out.println(new L224().calculate("1+1"));
    }
    public int calculate(String s) {
        /**
         * 将中缀表达式转化为后缀表达式
         */
        Stack<Character> stack = new Stack<>();
        int index=0;
        StringBuilder houzhui=new StringBuilder();
        while (index<s.length()){
            if (s.charAt(index)<='9' && s.charAt(index)>='0'){//如果是数字，则直接输出(当然这里的数字不一定是0~9)
                    houzhui.append(s.charAt(index));
            }else{//如果是运算符，则需要进栈进行处理
                if (s.charAt(index)==' '){//空格需要额外处理
                    index++;
                    continue;
                }
                if (!stack.isEmpty()){
                    char temp=stack.peek();
                    char charu=s.charAt(index);
                    if (charu=='('){
                        stack.push(charu);
                    }
                    if (temp=='(' && charu!=')'){//如果栈顶元素是(，并且要插入的元素不是)，那么直接插入
                        stack.push(charu);
                    }
                    if ((charu=='*' || charu=='/') && (temp=='+' || temp=='-')){
                        stack.push(charu);
                    }
                    if ((charu=='*' || charu=='/') && (temp=='*' || temp=='/')){
                        while(!stack.isEmpty() &&(stack.peek()=='*' || stack.peek()=='/')){
                            houzhui.append(stack.pop());
                        }
                        stack.push(charu);
                    }
                    if ((charu=='+' || charu=='-') && (temp=='*' || temp=='/' || temp=='+' || temp=='-')){
                        while (!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/' || stack.peek()=='-' || stack.peek()=='+')){
                            houzhui.append(stack.pop());
                        }
                        stack.push(charu);
                    }
                    if (charu==')'){//如果是)要插入，那么一直弹栈，知道找到(为止
                        while (stack.peek()!='('){
                            houzhui.append(stack.pop());
                        }
                        stack.pop();//弹出(
                    }
                }else{
                    stack.push(s.charAt(index));//如果栈为空，直接进栈
                }
            }
            index++;
        }
        while (!stack.isEmpty()){
            houzhui.append(stack.pop());
        }
        System.out.println(houzhui.toString());
        /**
         * 后缀表达式计算
         */
        String houzhuiResult=houzhui.toString();
        Stack<Integer> shuzi=new Stack<>();
        index=0;
        while (index<houzhuiResult.length()){//遇到数字直接入栈
            if (houzhuiResult.charAt(index)<='9' && houzhuiResult.charAt(index)>='0'){
                shuzi.push(Integer.parseInt(String.valueOf(houzhuiResult.charAt(index))));
            }else{//遇到符号，先从数字栈中弹出两个数字进行计算，然后再入栈
                int b=shuzi.pop();
                int a=shuzi.pop();
                if (houzhuiResult.charAt(index)=='+'){
                    shuzi.push(a+b);
                }
                if (houzhuiResult.charAt(index)=='-'){
                    shuzi.push(a-b);
                }
                if (houzhuiResult.charAt(index)=='*'){
                    shuzi.push(a*b);
                }
                if (houzhuiResult.charAt(index)=='/'){
                    shuzi.push(a/b);
                }
            }
            index++;
        }
        if (!shuzi.isEmpty())
        return  shuzi.pop();
        return 0;

    }
}
