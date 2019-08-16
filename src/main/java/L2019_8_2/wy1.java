package L2019_8_2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/3
 **/
public class wy1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        for(int i=-0;i<n;i++){
            a[i]=input.nextInt();
        }
        int q=input.nextInt();
        int[] x=new int[q];
        for(int i=0;i<q;i++){
            x[i]=input.nextInt();
        }
        DecimalFormat df = new DecimalFormat("#0.000000");
        double[] result=new double[n];
        for(int i=0;i<q;i++){//有多少个问题
            int index=x[i]-1;
            int score=a[index];
            int count=0;
            for(int j=0;j<n;j++){
                if(score>=a[j]){
                    count++;
                }
            }
            System.out.println(df.format((double)  (count-1)/n*100));
        }
    }
}
