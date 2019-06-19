package N2019_6_19;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/19
 **/
public class xuliezuixiaohua {
    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int  l = sc.nextInt();
        if(n==l){
            System.out.println(1);
        }
        else{
            result = (n-l)/(l-1) +1;
            if((n-l)%(l-1)>0) {
                result++;
            }
            System.out.println(result);
        }
    }
}
