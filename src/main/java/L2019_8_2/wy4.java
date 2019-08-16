package L2019_8_2;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/3
 **/
public class wy4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int q=input.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        for(int i=0;i<q;i++){
            int temp=input.nextInt();
            int result=0;
            for(int j=0;j<n;j++){
                if(nums[j]>=temp){
                    result++;
                    nums[j]-=1;
                }
            }
            System.out.println(result);
        }
    }
}
