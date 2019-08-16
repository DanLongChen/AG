package L2019_8_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/3
 **/
public class wy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] nums = new int[n];
        int[] asks = new int[q];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            asks[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < asks.length; i++) {
            System.out.println(core(nums, asks[i], n));
        }
    }

    public static int core(int[] nums, int key, int length) {
        int low = 0;
        int high = length - 1;
        int mid = (low + high) / 2;
        while (high > low) {
            mid = (low + high) / 2;
            if (nums[mid] >= key) {
                high = mid;
            } else if (nums[mid] < key) {
                low = mid + 1;
            }
        }
        if (nums[length - 1] < key) {
            return 0;
        }
        for (int i = low; i < length; i++) {
            nums[i] -= 1;
        }
        return length - low;
    }
}
