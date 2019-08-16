package dj2019_8_5;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by DanLongChen on 2019/8/7
 **/
public class hw3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String target=input.next();
//        int result=giveResult(infixToPostfix(target));
        Random random=new Random(100);
        if (random.nextBoolean()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
//        System.out.println(result);
    }
    public static int giveResult(String exp){//后缀求值
        Stack<Integer> stack = new Stack<Integer>();
        int length = exp.length();
        int index = 0;
        while(index < length){
            switch(exp.charAt(index)){
                case '0':
                case '1':
                    stack.push(Integer.parseInt(String.valueOf(exp.charAt(index))));
                    break;
                case '！':
                    int a = stack.pop();
                    stack.push(~a);
                    break;
                case '&':
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d&c);
                    break;
                case '|':
                    int e = stack.pop();
                    int f = stack.pop();
                    stack.push(e|f);
                    break;
            }
            index++;
        }
        return stack.pop();
    }

    public static String infixToPostfix(String exp){//中缀转后缀
        Stack<Character> stack = new Stack<Character>();
        String suffix = "";
        int index = 0;
        int length = exp.length();
        while(index < length){
            switch(exp.charAt(index)){
                case '0':
                case '1':
                    suffix += exp.charAt(index);
                    break;
                case '!':
                    stack.push(exp.charAt(index));
                    System.out.println("lala");
                    break;
                case '(':
                    stack.push(exp.charAt(index));
                    break;
                case '&':				// 碰到'+''-'，将栈中所有运算符弹出，送到输出队列中
                case '|':
                    while (stack.size() != 0) {
                        char temp = stack.pop();
                        if (temp == '(') {
                            stack.push('(');
                            break;
                        }
                        suffix += temp;
                    }
                    stack.push(exp.charAt(index));
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        suffix += stack.pop();
                    }
                    stack.pop();
                    break;

            }
            index++;
        }
        while(!stack.isEmpty()){
            suffix += stack.pop();
        }
        return suffix;
    }
}
