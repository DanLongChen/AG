package ByteCode;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/30
 **/
public class num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(nums[n-k-1]);
    }
}
