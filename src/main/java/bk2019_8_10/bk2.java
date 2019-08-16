package bk2019_8_10;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/10
 **/
public class bk2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        /**
         * 使用DP，先从第一个元素开始找，判断当前元素I的时候，从前面开始搜索，若当前元素>前面的某个元素，那么temp值就=dp【i】+1，dp[j]=Math.max(dp[i+1],temp)
         */
            int len = nums.length;
            if(len == 0){
                return 0;
            }
            int[] temp = new int[len];
            temp[0] = nums[0];
            int end = 0;
            for(int i = 1;i < len ; i++){
                if(nums[i] > temp[end]){
                    end++;
                    temp[end] = nums[i];
                }else{
                    int left = 0;
                    int right = end;
                    while(left < right){
                        int mid = (left + right)/2;
                        if(temp[mid] < nums[i]){
                            left = mid + 1;
                        }else{
                            right =mid;
                        }
                    }
                    temp[left] = nums[i];
                }
            }
            return end + 1;
        }
}
