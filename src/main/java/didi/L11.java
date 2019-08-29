package didi;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/27
 **/
public class L11 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=Integer.parseInt(input.nextLine());
        String[] chars=new String[n-1];
        int[] ints=new int[n];
        String s=input.nextLine();
        String[] arr=s.split(" ");
        int cIndex=0;
        int iIndex=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=="+" || arr[i]=="-" || arr[i]=="*" || arr[i]=="/"){
                chars[cIndex++]=arr[i];
            }else{
                ints[iIndex++]=Integer.parseInt(arr[i]);
            }
        }
        System.out.println(s);
    }
}
