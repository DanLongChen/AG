package L2019_8_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/3
 **/
public class wy32 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        boolean v1=false;
        boolean v2=false;
        int[] arr=new int[100050];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
            if(arr[i]%2==1){
                v1=true;
            }else{
                v2=true;
            }
        }
        if(v1 && v2){
            Arrays.sort(arr);
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    private static void swap(int[] arr,int low,int height){
        arr[low]=arr[low]^arr[height];
        arr[height]=arr[low]^arr[height];
        arr[low]=arr[low]^arr[height];
    }
}
