package qs2019_8_8;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/8
 **/
public class qu2 {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        int[] coins=new int[6];
        int value=0;
        for(int i=0;i<6;i++){
            int temp=input.nextInt();
            coins[i]=temp;
            value+=temp;
        }
        int[] values={1,5,10,20,50,100};
        int[] maxCoins=new int[value];
        int index=0;
        int point=0;
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<coins[i];j++){
                maxCoins[index++]=values[point];
            }
            point++;
        }
        int target=input.nextInt();
        backtrack(maxCoins,new int[maxCoins.length],target,0,0);
        System.out.println(count);
    }
    public static int count=0;

    public static void backtrack(int[] input,int[] record,int key,int sum,int n) {
        if(n == input.length){
            return;
        }else{
            for(int i=0; i<=1; i++){
                sum += i*input[n];
                record[n] = i;
                if(sum == key){
                    for(int j=0; j<=n; j++){
                        if(record[j]==1)
                            count++;
                    }

                }
                if(sum<key){
                    backtrack(input, record, key, sum, n+1);
                }
                sum -= i*input[n];
            }
        }
    }



}
