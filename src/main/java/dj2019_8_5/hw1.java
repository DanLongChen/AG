package dj2019_8_5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/7
 **/
public class hw1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        if(s.charAt(s.length()-1)=='@'){
            System.out.println(s.substring(0,s.length()-1));
            return;
        }
        String[] message=s.split("@");
        /**
         * 还需要考虑一个字符都没有占用的情况
         */
        String message1=message[0];//前后进行划分
        String message2=message[1];
        String[] pres=message1.split(",");
        String[] afts=message2.split(",");
        Map<String,Integer> map1=new LinkedHashMap<>();
        for(int i=0;i<pres.length;i++){
            String[] temp=pres[i].split(":");
            map1.put(temp[0],Integer.parseInt(temp[1]));
        }
        int count=0;
        for(int i=0;i<afts.length;i++){
            String[] temp=afts[i].split(":");
            if(Integer.valueOf(temp[1])==0){
                count++;
            }
            if(map1.containsKey(temp[0])){
                map1.put(temp[0],map1.get(temp[0])-Integer.valueOf(temp[1]));
            }
        }
        String result="";
        for(Map.Entry entry:map1.entrySet()){
            if((int)entry.getValue()==0){
                continue;
            }
            String temp=entry.getKey()+":"+entry.getValue()+",";
            result+=temp;
        }
        System.out.println(result.substring(0,result.length()-1));

    }
}
