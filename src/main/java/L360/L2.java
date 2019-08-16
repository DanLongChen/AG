package L360;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by DanLongChen on 2019/8/15
 **/
public class L2 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();//n个数
        int m=input.nextInt();//m进制
        int[] a=new int[n];
        int[] b=new int[n];

        for (int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        for (int i=0;i<n;i++){
            b[i]=input.nextInt();
        }
        int[] result=new int[n];
        boolean[] flag=new boolean[n];//标记第二个有没有取过
        for(int i=0;i<n;i++){
            int temp=a[i];
            int max=0;
            int index=0;
            for(int j=0;j<n;j++){
                if((temp+b[j])%m>max && flag[j]==false){
                    max=(temp+b[j])%m;
                    index=j;
                }
            }
            result[i]=max;
            flag[index]=true;
        }
        Arrays.sort(result);
        for (int i=result.length-1;i>=0;i--){
            System.out.print(result[i]+" ");
        }

    }
}
