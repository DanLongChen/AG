package youzan;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/20
 **/
public class L2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s=sc.next();
        String[] s1=s.split(",");
        int[] arr = new int[n];
        for(int i =0;i<n;i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++) {
            //假设删除该点
            min = Integer.min(min, distance(arr,i));
        }
        System.out.println(min);
    }

    public static int distance(int[] arr,int i) {
        int tmp = arr[i];
        if(i == 0) {
            arr[i] = arr[i+1];
        }else {
            arr[i] = arr[i-1];
        }
        int d = 0;
        for(int j = 1;j<arr.length;j++) {
            d += Math.abs(arr[j] - arr[j-1]);
        }
        arr[i] = tmp;
        return d;
    }

}
