package L2019_7_21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Paser on 2019/7/21.
 * 字符串解码
 */
public class L394 {
    public String decodeString(String s) {
        //可以借助于栈，遇到左括号什么的先入栈，遇到右括号进行出栈运算操作
        if(s==null || s.length()==0){
            return s;
        }
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            //将s中的元素依次入栈，遇到右括号进行出栈操作
            if(s.charAt(i)==']'){
                String temp="";
                while (stack.peek()!='['){
                    temp=stack.pop()+temp;//头部插入，否则顺序是反的
                }
                stack.pop();
                String stringNum="";
                while (!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    stringNum=stack.pop()+stringNum;
                }
                int num=Integer.parseInt(stringNum);
                System.out.println(temp+"  "+num);
                String temp1=temp;
                temp="";
                for (int j=0;j<num;j++){
                    temp+=temp1;
                }
                System.out.println(temp);
                //然后再入栈
                for (int j=0;j<temp.length();j++){
                    stack.push(temp.charAt(j));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        //最后返回结果，注意逆序
        String result="";
        while (!stack.isEmpty()){
            result=stack.pop()+result;
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new L394().decodeString(s));
    }
}
