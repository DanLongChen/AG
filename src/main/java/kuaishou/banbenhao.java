package kuaishou;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/25
 **/
public class banbenhao {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=Integer.parseInt(input.nextLine());
        for(int i=0;i<n;i++){
            String s=input.nextLine();
//            System.out.println(s);
            String[] arr=s.split("\\s+");
//            System.out.println(Arrays.toString(arr));
            if(compareVersion(arr[0],arr[1])==-1){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }
    }
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length;
        int l2 = v2.length;
        int min=Math.min(l1,l2);
        for(int i=0; i<min; i++){
            int i1 = Integer.valueOf(v1[i]);
            int i2 = Integer.valueOf(v2[i]);
            if(i1<i2){
                return -1;
            }else if(i1>i2){
                return 1;
            }
        }
        if(l1>l2){
            for(int i=min; i<l1; i++){
                if(Integer.valueOf(v1[i])!=0){
                    return 1;
                }
            }
            return 0;
        }else if(l1<l2){
            for(int i=min; i<l2; i++){
                if(Integer.valueOf(v2[i])!=0){
                    return -1;
                }
            }
            return 0;
        }else{
            return 0;
        }
    }
}
