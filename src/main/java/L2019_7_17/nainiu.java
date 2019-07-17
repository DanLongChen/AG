package L2019_7_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/7/17
 **/
public class nainiu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();//总共的奶牛数
        int k=input.nextInt();//丢失的奶牛数
        int sum=0;//因为编号和能被n整除（个数为k）
        int temp=0;
        int maxN=n-1;
        while(temp<k){
            temp++;
            sum+=(maxN--);
        }
        System.out.println(sum);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=n;i<=sum;i+=n){
            System.out.println(i);
            handler(14,result,new ArrayList<>(),n,k,0,0);
        }
        System.out.println(result);
    }
    private static void handler(int target,List<List<Integer>> result,List<Integer> list,int n,int k,int sum,int index){
        if(list.size()==k && sum==target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>k){
            return;
        }
        for(int i=0;i<n;i++){
            if(list.contains(i)){
                continue;
            }
            list.add(index);
            sum+=index;
            handler(target,result,list,n,k,sum,i);
            list.remove(list.size()-1);
            sum-=index;
        }
    }
}
