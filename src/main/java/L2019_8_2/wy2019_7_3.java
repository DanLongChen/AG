package L2019_8_2;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/2
 * 丰收
 **/
public class wy2019_7_3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        int[] sum=new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
            if(i==0){
                sum[i]=a[i];
            }else{
                sum[i]=sum[i-1]+a[i];
            }
        }
        int m=input.nextInt();
        for(int i=0;i<m;i++){
            int temp=input.nextInt();//下面的查找可以使用二分
            int left=0,right=sum.length-1;
            while(left<right){//这里不能使用<=
                int mid=(left+right)/2;
                if(temp<=sum[mid]){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            System.out.println(left+1);//这里是因为从0开始计数
        }
    }
}
