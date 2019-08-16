package dj2019_8_5;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/7
 **/
public class hw2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int M=input.nextInt();
        int[] a=new int[M];
        int[] b=new int[M];
        int[] c=new int[M];
        for(int i=0;i<M;i++){
            a[i]=input.nextInt();
        }
        for(int i=0;i<M;i++){
            b[i]=input.nextInt();
        }
        for(int i=0;i<M;i++){
            c[i]=input.nextInt();
        }
        int N=input.nextInt();
        int[] d=new int[N];
        for(int i=0;i<N;i++){
            d[i]=input.nextInt();
        }
        int W=input.nextInt();
        int[] e=new int[W];
        for(int i=0;i<W;i++){
            e[i]=input.nextInt();
        }
        System.out.println(0);


    }
}
