package L2019_8_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DanLongChen on 2019/8/3
 **/
public class quanpailie {
        public static void main(String[] args) {
            int[] arr = { 1, 1, 3, 4 };
            System.out.println(permuteUnique(arr));
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
