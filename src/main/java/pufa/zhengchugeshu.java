package pufa;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/17
 **/
public class zhengchugeshu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int b=input.nextInt();
        int result=0;
        for(int i=1;i<=n;i++){
            if(i%b==0){
                result++;
            }
        }
        System.out.println(result);
    }

}
