package L2019_4_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不同的整数，求其全部排列数（其中可能存在重复项）
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * Created by Paser on 2019/4/6.
 */
public class L47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /**
         * 首先对nums进行排序，排序之后相同的数字都会到一块儿
         */
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        handler(result, new ArrayList<Integer>(), arr);
        return result;

    }

    public void handler(List<List<Integer>> result, List<Integer> temp, List<Integer> arr) {
        if (arr.isEmpty()) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            /**
             * 在前后相同的情况下不作处理，让i继续向后移动一位（因为之前已经经过了排序），目的也是为了让两个紧挨着的相同的数分散
             */
            if (i +1 < arr.size() && arr.get(i) == arr.get(i + 1)) {
                continue;
            }
            List<Integer> list = new ArrayList<>(temp);
            list.add(arr.get(i));
            List<Integer> newArr = new ArrayList<>(arr);
            newArr.remove(i);
            handler(result, list, newArr);

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(new L47().permuteUnique(arr));
    }
}
