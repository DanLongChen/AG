package bk2019_8_10;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by DanLongChen on 2019/8/10
 **/
public class bk4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        int result=handler(n,nums);
        System.out.println(result);

    }
    private static int handler(int n,int[] nums){
        int[] min=new int[1];
        int left=0,right=n-1;
        help(left,right,min,nums);
        return min[0];
    }
    public static int help(int left,int right,int[] min,int[] nums){
        while(left<right){
            while(left<right && nums[left]<nums[left+1]){
                left++;
            }
            while(left<right && nums[right-1]>nums[right]){
                right--;
            }
            if(left<right){
                min[0]+=nums[left]+1-nums[left+1];
                nums[left+1]=nums[left]+1;
                left++;
            }
        }
        return min[0];
    }
}
