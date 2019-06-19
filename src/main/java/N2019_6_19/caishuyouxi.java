package N2019_6_19;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/19
 * 猜数游戏
 **/
public class caishuyouxi {
    private static int mod=1000000007;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        counter(in.nextInt());
    }
    public static void counter(int num){
        long result=1;
        boolean[] flag=new boolean[num+1];
        for (int i=2;i<=num;i++){
            if (flag[i]){
                continue;
            }
            for (int j=i*2;j<=num;j+=i){
                flag[j]=true;
            }
            int count=0;
            long k=i;
            while (k<=num){
                k*=i;
                count++;
            }
            result=result*(count+1)%mod;
        }
        System.out.println(result);
    }

}
