package pufa;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/17
 **/
public class shangtaijie {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int in=0;
        while((in=input.nextInt())!=0){
            System.out.println(hanlder(in));
        }
    }
    public static int hanlder(int n){
        int[] dp=new int[n+1];
        if(n==1 || n==2){
            return n;
        }
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
