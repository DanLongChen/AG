package wy2019_8_3;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/4
 * 奇怪的信
 * 链接：https://www.nowcoder.com/questionTerminal/d7764905e41a413c98900e22a9cc4ec3
 * 来源：牛客网
 *
 * 现在你需要用一台奇怪的打字机书写一封书信。信的每行只能容纳宽度为100的字符，也就是说如果写下某个字符会导致行宽超过100，那么就要另起一行书写
 * 信的内容由a-z的26个小写字母构成，而每个字母的宽度均会事先约定。例如字符宽度约定为[1,2,3,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5]，那么就代表'a'到'd'四个字母的宽度分别是1,2,3,4，而'e'到'z'的宽度均为5
 * 那么按照上述规则将给定内容S书写成一封信后，这封信共有几行？最后一行宽度是多少？
 **/
public class qiguaidexin {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] length=new int[26];
        for(int i=0;i<26;i++){
            length[i]=input.nextInt();
        }
        String message=input.next();
        int result=1;
        int width=0;
        for(int i=0;i<message.length();i++){
            int index=message.charAt(i)-'a';
            if(width+length[index]>100){
                result+=1;
                width=0;
            }
            width+=length[index];

        }
        System.out.println(result+" "+width);
    }
}
