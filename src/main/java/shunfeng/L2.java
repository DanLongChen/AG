package shunfeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/29
 **/
public class L2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[] nums = new int[n];
        String s = input.nextLine();
        String[] strings = s.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.print(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        List<Integer> lisList = new ArrayList<>();
        lisList.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=lisList.get(lisList.size()-1)){
                lisList.add(nums[i]);
            }else {
                for(int j=0;j<lisList.size();j++){
                    if(nums[i]<=lisList.get(j)){
                        lisList.set(j,nums[i]);
                        break;
                    }
                }
            }
        }
        return lisList.size();
    }
}
