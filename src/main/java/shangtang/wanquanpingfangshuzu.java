package shangtang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/19
 * 完全平方数组
 **/
public class wanquanpingfangshuzu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        System.out.println(check(permuteUnique(nums)));
    }
    public static int check(List<List<Integer>> list){
        int result=0;
        for(int i=0;i<list.size();i++){
            boolean flag=false;
            for(int j=0;j<list.get(i).size()-1;j++){
                int temp=list.get(i).get(j)+list.get(i).get(j+1);
                if(!isSqrt(temp)){
                    flag=true;
                   break;
                }
            }
            if (!flag)
            result++;
        }
        return result;
    }
    static boolean isSqrt(double num){
        String regex = "\\d+.0+";
        return(Math.sqrt(num)+"").matches(regex);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        handler(result, new ArrayList<Integer>(), arr);
        return result;

    }

    public static void handler(List<List<Integer>> result, List<Integer> temp, List<Integer> arr) {
        if (arr.isEmpty()) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list = new ArrayList<>(temp);
            list.add(arr.get(i));
            if (i +1 < arr.size() && arr.get(i) == arr.get(i + 1)) {

                continue;
            }
            List<Integer> newArr = new ArrayList<>(arr);
            newArr.remove(i);
            handler(result, list, newArr);

        }
    }
}
