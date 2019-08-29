package didi;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/27
 **/
public class L2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int total=input.nextInt();
        int cost=input.nextInt();
        int[] arrA=new int[n];
        int[] arrB=new int[n];
        for (int i = 0; i <n ; i++) {
            arrA[i]=input.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            arrB[i]=input.nextInt();
        }
        Random random=new Random();
        System.out.println(random.nextInt());
    }
}
