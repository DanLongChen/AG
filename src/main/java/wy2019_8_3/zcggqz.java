package wy2019_8_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/8/4
 **/
public class zcggqz {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s=input.next();
        if(s.length()==0){
            System.out.println("");//处理异常情况
            return;
        }
        String[] arr=s.split(",");
        System.out.println(MaxPrefix(arr));
    }
    public static String MaxPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        StringBuilder builder=new StringBuilder();
        int min=strs[0].length();
        /**
         * 现求出最小长度
         */
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
            }
        }
        int index=0;
        out:
        while (true){
            Set<Character> set=new HashSet<>();
            if(index<min){
                set.add(strs[0].charAt(index));
            }else{
                break ;
            }
            for (int i=1;i<strs.length;i++){
                if(index<min){
                    if(set.contains(strs[i].charAt(index))){
                        continue;
                    }else{
                        break out;
                    }
                }
            }
            builder.append(strs[0].charAt(index));
            index++;
        }
        return builder.toString();
    }
}
