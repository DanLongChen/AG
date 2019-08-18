package pufa;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/17
 **/
public class sushu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(isSushu(n));
    }
    private static boolean isSushu(int n){
        int i=n;
        if(i<2){
            return false;
        }else{
            for(i=n-1;i>=2;i--){
                if(n%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
