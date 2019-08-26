package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/23
 **/
public class dajiajieshe {
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        System.arraycopy(a,1,a,0,3);
        System.out.println(Arrays.toString(a));
//        Scanner input=new Scanner(System.in);
//        String s=input.next();
//        String[] arr=s.split(",");
//        int[] nums=new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            nums[i]=Integer.parseInt(arr[i]);
//        }
//        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        //还要判断第一个和最后一个会不会同时被抢，第一个如果被抢，那么最后一个不能被抢
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int result1=handler(nums,0,nums.length-1);
        int result2=handler(nums,1,nums.length);
        return Math.max(result1,result2);
    }
    private static int handler(int[] nums,int start,int end){
        int rob=0;
        int norob=0;
        for(int i=start;i<end;i++){
            int currob=norob+nums[i];
            norob=Math.max(rob,norob);
            rob=currob;
        }
        return Math.max(rob,norob);
    }
}
