package Lkedaxunfei;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/16
 **/
public class L2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String in=input.next();//按照行进行输入，因为输入{11,13,15,17,19,21}这样子的形式，所以需要对这个字符串进行处理
        if(in.length()==0){//若没有输入，直接返回
            System.out.println(-1);
            return;
        }
        in=in.substring(1,in.length()-1);
        if(in.length()==0){
            System.out.println(-1);
            return;
        }
        String[] chars=in.split(",");//首先去掉头尾的{}，然后按照“,”进行分割
        int[] nums=new int[chars.length];
        for(int i=0;i<chars.length;i++){
            nums[i]=Integer.valueOf(chars[i]);//对分割出来的数进行转换，转化为数字
        }
        System.out.println(binarySearch(nums,19,0,nums.length-1)+1);

    }
    public static int binarySearch(int[] shuzu, int numKey, int start, int end) {
        int mid = (end - start) / 2 + start;//首先计算中间点的index
        if (start > end) {//边界条件
            return -1;
        }
        if (numKey < shuzu[mid]) {//若目标key<mid，则往左边找
            return binarySearch(shuzu, numKey, start, mid - 1);
        } else if (numKey > shuzu[mid]) {//否则往右边找
            return binarySearch(shuzu, numKey, mid + 1, end);
        } else {
            return mid;
        }
    }
}
