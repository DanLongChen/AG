package L2019_7_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/7/17
 **/
public class zuidashenggaocha {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        int[] nums=new int[num];
        for(int i=-0;i<num;i++){
            nums[i]=input.nextInt();
        }
        /**
         * 使用递归求出每一种可能，然后计算每一种可能的身高差的最大值，再在里面求一个最小值
         */
        List<List<Integer>> result=new ArrayList<>();
        handler(nums,result,new ArrayList<>());
        System.out.println(max(result));
    }
    private static void handler(int[] nums, List<List<Integer>> result,List<Integer> temp){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            handler(nums,result,temp);
            temp.remove(temp.size()-1);
        }
    }
    private static int max(List<List<Integer>> list){
        int min=Integer.MAX_VALUE;
        for(List<Integer> temp:list){
            int maxC=0;
            for(int i=0;i<temp.size()-1;i++){
                int temp1=Math.abs(temp.get(i+1)-temp.get(i));
                if(temp1>maxC){
                    maxC=temp1;
                }
            }
            maxC=Math.max(maxC,Math.abs(temp.get(temp.size()-1)-temp.get(0)));

            min=Math.min(min,maxC);
        }
        return min;
    }
}
