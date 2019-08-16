package Lkedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/16
 **/
public class L1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();//首先按照行输入
        if(s.length()==0){//若没有输入，直接返回
            System.out.println("");
            return;
        }
        char[] str = s.toCharArray(); //把字符串转为字符数组
        StringBuffer buf = new StringBuffer();//创建buffer用作string变量
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                buf.append(str[i]); //数字都放在buffer中
            }
        }

        String st = buf.toString();//把buffer转为字符串
        char[] arr = st.toCharArray();
        Arrays.sort(arr);//进行排序
        System.out.println(new String(arr));//进行输出
    }
}
