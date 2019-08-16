package bk2019_8_10;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/10
 **/
public class bk1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        long[] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextLong();
        }
        long[] result=new long[2];
        long  min=Long.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(Math.abs(nums[i]-nums[i+1])<min){
                min=Math.abs(nums[i]-nums[i+1]);
                result[0]=nums[i];
                result[1]=nums[i+1];
            }
        }
        System.out.println(result[0]+" "+result[1]);
    }
}
