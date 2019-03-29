package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Paser on 2019/2/27.
 */
class Main {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        Scanner input=new Scanner(System.in);
        for(int i=0;i<26;i++){
            list.add(input.nextInt());
        }
        String string=input.next();
        char[] message=string.toCharArray();
        int lineNum=1;
        int lastLength=0;
        int count=0;
        for(int i=0;i<message.length;i++){
            int temp=message[i]-'a';
            if((count+list.get(temp))<=100){
                count+=list.get(temp);
                lastLength=count;
            }else{
                lineNum++;
                System.out.println(lineNum);
                count=0;
                lastLength=0;
                --i;
            }
        }
        System.out.println(lineNum+" "+lastLength);


    }
}

