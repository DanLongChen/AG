package bk2019_8_10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/10
 **/
public class bk3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        double[] nums=new double[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextDouble();
        }
        Arrays.sort(nums);
        int result=getResult(n,nums);
        System.out.println(result);
    }
    public static int getResult(int n, double[] nums){
        int result=0;
        int i=0;
        while (i<n){
            double temp=nums[i]/0.9;
            int j= Arrays.binarySearch(nums,temp);
            if(j<0){
                j=-(j+1);
                result+=j-i-1;
            }else{
                result+=j-i;
            }
            i++;
        }
        return result;
    }
}
