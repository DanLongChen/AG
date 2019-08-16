package wy2019_8_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/4
 *
 *
 * 链接：https://www.nowcoder.com/questionTerminal/8ff3e3a14ea04c6bb3a60e2e457dafb1
 * 来源：牛客网
 *
 * 思路就是尽量让孩子颜色相同把。
 * 首先孩子的报数加1即是持有该颜色糖果的小朋友个数，如果报数不同，那么肯定持有糖果颜色也不同。
 * 报数相同，也不一定说明颜色就相同，比如说报数为（2，2）或者（2，2，2）时，可以认为小朋友都颜色相同，所以结果都是2+1=3，但（2，2，2，2）时就不行了，
 * 因为如果认为是相同颜色的话，那么有三个人与自己一样颜色，和2冲突了，不可能是2了。所以可以认为前三个人是一样颜色，后1个是另一种颜色，结果是3+3，
 * 当输入是（2，2，2，2，2，2，2）时，一样认为前三个是一种颜色，接下去三个是一种颜色，剩下的是一种颜色，也就是3+3+3了。
 * 然后就可以将输入划分成这样各个相等的序列，用map，对每个map对，看他的个数与自身的值+1进行比较。每个序列的结果加起来就行了
 **/
public class tangguomiti {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] count=new int[1000];
        int index=0;
        while(input.hasNext()){
            count[index++]=input.nextInt();
        }
        int result=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<index;i++){
            int temp=count[i];
            if(!map.containsKey(temp)){
                result+=temp+1;
                map.put(temp,1);
            }
            else if(map.get(temp)<=temp){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
                result+=temp+1;
            }
        }
        System.out.println(result);
    }
}
