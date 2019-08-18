package pufa;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/17
 **/
public class oushu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int in=input.nextInt();
        int t=in;
        int result=0;
        while(t!=0){
            int temp=t%10;
            t/=10;
            if((temp&1)==0){
                result+=temp;
            }
        }
        System.out.println(result);
    }
}
