package SuanFa;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/3/14
 **/
public class Erchashu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int k=input.nextInt();
        int i=1;
        int nowData=1;//记录当前节点的数值
        if(nowData+nowData*2>=n){
            n-=nowData;
            System.out.println(nowData+" +");
        }else{
            n+=nowData;
            System.out.println(nowData+" -");
        }
        while (i<k){
            if(n-(nowData*2+1)==0){
                System.out.println(nowData+" +");
                break;
            }else{
                n-=nowData*2;
                nowData=nowData*2;
                System.out.println(nowData+" +");
            }
            i++;
        }
    }
    public static void handler(int n,int k){
        if(k<=0){
            return;
        }

    }
}

